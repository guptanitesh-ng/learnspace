package com.concepts.elasticsearch.configuration;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetMappingsRequest;
import org.elasticsearch.client.indices.GetMappingsResponse;
import org.elasticsearch.client.indices.PutMappingRequest;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.concepts.elasticsearch.core.ElasticSearchClient;
import com.concepts.elasticsearch.model.Employee;
import com.concepts.elasticsearch.model.Employee.EmployeeBuilder;
import com.concepts.elasticsearch.model.EmployeeData;
import com.concepts.elasticsearch.model.Gender;
import com.concepts.elasticsearch.model.MaritalStatus;
import com.concepts.elasticsearch.model.Project;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ESApplicationRunner implements ApplicationRunner {

    private static final String EMPLOYEES = "employees";
    private ElasticSearchClient client;

    @Autowired
    private ResourceLoader resourceLoader;

    public ESApplicationRunner(ElasticSearchClient client) {
        this.client = client;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        RestHighLevelClient restHighLevelClient = client.getRestHighLevelClient();
        System.out.println("High level rest client is configured: " + restHighLevelClient);

        // Delete Index
        //DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(EMPLOYEES);
        //restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);

        // Create Index
        //CreateIndexRequest createIndexRequest = new CreateIndexRequest(EMPLOYEES);
        //AcknowledgedResponse createIndexResponse = restHighLevelClient.indices()
          //      .create(createIndexRequest, RequestOptions.DEFAULT);
        //System.out.println("Created Index: " + createIndexResponse);

        // Update Mapping
        // This is equivalent to the PUT mapping API. e.g. PUT /employees/_mapping
        //PutMappingRequest putMappingRequest = new PutMappingRequest(EMPLOYEES);
        //XContentBuilder builder = createMapping();
        //putMappingRequest.source(builder);
        //AcknowledgedResponse putMappingResponse = restHighLevelClient.indices()
          //      .putMapping(putMappingRequest, RequestOptions.DEFAULT);
        //System.out.println("Update mapping:" + putMappingResponse);

        // Get Mapping
        GetMappingsRequest getMappingsRequest = new GetMappingsRequest();
        getMappingsRequest.indices(EMPLOYEES);
        GetMappingsResponse mapping = restHighLevelClient.indices().getMapping(getMappingsRequest,
                RequestOptions.DEFAULT);
        mapping.mappings().forEach((k, v) -> {
            System.out.println(k + " " + v.sourceAsMap());
        });

        // Bulk Index
        List<Employee> employees = getEmployees();
        // employees.stream().limit(10).forEach(e -> System.out.println(e));
        ObjectMapper objectMapper = new ObjectMapper();

        IntStream.range(0, employees.size() / 100).forEach(i -> {
            int index = i * 100;
            int toIndex = index + 100;
            BulkRequest request = new BulkRequest();
            employees.subList(i * 100, toIndex).stream().forEach(e -> {
                StringWriter writer = new StringWriter();
                try {
                    objectMapper.writeValue(writer, e);
                }
                catch (IOException e1) {
                    e1.printStackTrace();
                }
                request.add(
                        new IndexRequest(EMPLOYEES).source(writer.toString(), XContentType.JSON));
                writer.flush();
            });
            
                //BulkResponse bulkResponse = restHighLevelClient.bulk(request,
                  //      RequestOptions.DEFAULT);
                //bulkResponse.forEach(r -> System.out.println(r.getId()));
            

        });

        // Put Document
        IndexRequest indexRequest = new IndexRequest(EMPLOYEES);
        indexRequest.source(createDocumentSource(), XContentType.JSON);
        IndexResponse indexResponse = restHighLevelClient.index(indexRequest,
                RequestOptions.DEFAULT);
        indexResponse.getId();

        // Get Document
        GetRequest getRequest = new GetRequest(EMPLOYEES, indexResponse.getId());
        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(getResponse);
    }

    private List<Employee> getEmployees()
            throws IOException, JsonProcessingException, JsonMappingException {
        List<EmployeeData> employeeDataList = readInitialData();

        List<Employee> employees = new ArrayList<>();
        List<Entry<String, String>> projectDictionary = getProjects();
        Random random = new Random();
        AtomicInteger employeeId = new AtomicInteger(1);
        employeeDataList.stream().forEach((e) -> {
            EmployeeBuilder employeeBuilder = new EmployeeBuilder(employeeId.getAndIncrement(),
                    e.getFirstName(), e.getLastName(), e.getDesignation(), e.getAddress(),
                    Gender.valueOf(e.getGender()), e.getAge(),
                    MaritalStatus.valueOf(e.getMaritalStatus()));
            employeeBuilder.interests(Arrays.asList(e.getInterests().split(",")));
            employeeBuilder.joiningDate(e.getDateOfjoining());
            employeeBuilder.salary(e.getSalary());

            Set<Project> projects = new HashSet<>();
            int count = random.nextInt(3);
            for (int i = 0; i < count; i++) {
                Entry<String, String> entry = projectDictionary
                        .get(random.nextInt(projectDictionary.size()));
                projects.add(new Project(entry.getValue(), entry.getKey()));
            }
            employeeBuilder.projects(projects);

            if (employees.size() > 0) {
                employeeBuilder.supervisor(employees.stream().skip(random.nextInt(employees.size()))
                        .findFirst().orElse(null));
            }

            employees.add(employeeBuilder.build());
        });
        return employees;
    }

    private List<EmployeeData> readInitialData()
            throws IOException, JsonProcessingException, JsonMappingException {
        Resource resource = resourceLoader.getResource("classpath:Employees50K.json");
        List<EmployeeData> employeeDataList = new ArrayList<>();
        try (LineNumberReader lineNumberReader = new LineNumberReader(
                new InputStreamReader(resource.getInputStream()))) {
            String readLine = null;
            ObjectMapper mapper = new ObjectMapper();

            while (!StringUtils.isEmpty(readLine = lineNumberReader.readLine())) {
                if (lineNumberReader.getLineNumber() % 2 == 0) {
                    employeeDataList.add(mapper.readValue(readLine, EmployeeData.class));
                }
            }
        }
        return employeeDataList;
    }

    private List<Entry<String, String>> getProjects() {
        String values = "Amigos,Antique,Apollo,Astro,Atlantis,Aurora,Balto,Barcelona,Barney,Barracuda,Batman,Bender,Bigfish,Bigfoot,Bladerunner,Blue Moon,Blue Skywalkers,Bongo,Bordeaux,Bride of Buster,Bulldozer,Bullwinkle,Business as Unusual,Camelot,Canary,Casanova,Cascade,Cauldron,Caveman Lawyers,Charming Chicks,Cheerio,Cherrystone,Cinnamon,Cold Fusion,Colossus,Colusa,Constantine,Cowbelles,Crusader,Cyclone,Dagwood,Dangerous Rocks,Darwin,Deepmind,DejaVu,Dessert Storm,Diesel,Disco Divas,Disco Ninjas,Duracell,Duraflame,Durango,Eagle,Early First,Echo Lake,Edison,Einstein,Elixir,Elmer,Excalibur,Fester,Fireball,Firefly,Firestorm,Firetruck,Flamingo,Flyers,Fusion,Galactica,Gemini,Gold Star,Golden Bulls,Gray Panthers,Green Jade,Hades,Hercules,Hidden Hook,Honeycomb,Horned Frogs,Hornets,Husky Cat,Hydra,Indigo,Irongate,Ivory,Jaguar,Jonah,Jupiter,Kanga,KingFish,Kingsmen,Kodiak,Kryptonite,Laguna,Lemon Drops,Liberation,Liquid Sky,Lobster,Longhorns,Lorax,Mad Hatter,Malibu,Mango,Maroon,Massive Monkey,Matadors,Mercury,Metro,Moonshine,Mountaineers,Mustangs,Nautilus,Nitro,Odyssey,Omega,Orange Dots,Orion,Peacocks,Pharoahs,Phoenix,Pink Dragons,Pink Ladies,Pluto,Poseidon,Prelude,Project X,Pure Panther,Python,Quadro,Quicksilver,Rampage,Red Butter,Revolution,Rhinestone,Riviera,Roadrunner,Romeo,Royal,Sahara,Sea Lions,Seawolves,Sirius,Skyhawks,Soul Spartans,Sputnik,Stratos,Striped Foxes,Sultans of Sales,Sunburst,Sunergy,The Bomb Squad,The Violent Storms,Timberwolves,Titan,Topaz,Topcat,Torpedo,Tribe,Vikings,Vipers,Voyager,Weekend Warriors,Westerners,Whistler,White Feather,Wide Stringer,Wombat,Xena,Yaeger,Yellow Moose,Yoda,Yosemite,Zeus,Zircon,Zulu";
        List<String> asList = Arrays.asList(values.split(","));
        Map<String, String> projectMapping = new HashMap<>();
        asList.forEach((s) -> projectMapping.put(getCode(), s));
        List<Entry<String, String>> projects = new ArrayList<>();
        projects.addAll(projectMapping.entrySet());
        return projects;
    }

    private String getCode() {
        Random random = new Random();
        return random.ints(65, 91).limit(4)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .append(random.ints(48, 58).limit(8).collect(StringBuilder::new,
                        StringBuilder::appendCodePoint, StringBuilder::append).toString())
                .toString();
    }

    private String createDocumentSource() throws IOException {
        EmployeeBuilder builder = new Employee.EmployeeBuilder(1, "jack", "Jill",
                "Chairman and Managing Director", "Hopeway 29, Dreamland", Gender.Male, 42,
                MaritalStatus.Married);
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1999, 03, 30);
        builder.joiningDate(calendar.getTime());
        builder.salary(500000000L);

        String[] interests = { "Golf", "Snooker" };
        builder.interests(new HashSet<>(Arrays.asList(interests)));

        Project project = new Project("Drive Growth", "Manager");
        builder.projects(new HashSet<>(Arrays.asList(project)));

        builder.supervisor(
                new Employee.EmployeeBuilder(1, "John", "Bets", "Chairman and Managing Director",
                        "Hopeway 29, Dreamland", Gender.Male, 42, MaritalStatus.Married).build());

        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        objectMapper.writeValue(writer, builder.build());

        return writer.toString();
    }

    private XContentBuilder createMapping() throws IOException {
        XContentBuilder builder = XContentFactory.jsonBuilder();
        builder.startObject();
        builder.startObject("properties");
        {
            builder.startObject("employee_id");
            {
                builder.field("type", "integer");
            }
            builder.endObject();

            builder.startObject("first_name");
            {
                builder.field("type", "text");
            }
            builder.endObject();
            builder.startObject("last_name");
            {
                builder.field("type", "text");
            }
            builder.endObject();
            builder.startObject("designation");
            {
                builder.field("type", "text");
            }
            builder.endObject();
            builder.startObject("salary");
            {
                builder.field("type", "long");
            }
            builder.endObject();
            builder.startObject("date_of_joining");
            {
                builder.field("type", "date");
                builder.field("format", "yyyy-MM-dd");
            }
            builder.endObject();
            builder.startObject("address");
            {
                builder.field("type", "text");
            }
            builder.endObject();
            builder.startObject("gender");
            {
                builder.field("type", "keyword");
            }
            builder.endObject();
            builder.startObject("age");
            {
                builder.field("type", "integer");
            }
            builder.endObject();
            builder.startObject("marital_status");
            {
                builder.field("type", "keyword");
            }
            builder.endObject();
            builder.startObject("projects");
            {
                builder.field("type", "nested");
                builder.startObject("properties");
                {
                    builder.startObject("name");
                    {
                        builder.field("type", "text");
                    }
                    builder.endObject();
                    builder.startObject("role");
                    {
                        builder.field("type", "text");
                    }
                    builder.endObject();
                }
                builder.endObject();
            }
            builder.endObject();
            builder.startObject("interests");
            {
                builder.field("type", "text");
            }
            builder.endObject();
            builder.startObject("supervisor");
            {
                builder.field("type", "object");
                builder.startObject("properties");
                {
                    builder.startObject("first_name");
                    {
                        builder.field("type", "text");
                    }
                    builder.endObject();
                    builder.startObject("last_name");
                    {
                        builder.field("type", "text");
                    }
                    builder.endObject();
                }
                builder.endObject();
            }
            builder.endObject();
        }
        builder.endObject();
        builder.endObject();
        return builder;
    }

}
