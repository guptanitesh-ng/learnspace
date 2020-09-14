import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author nitesh
 *
 */
public class Solution {

	private Map<String, List<SoftwareMetaInfo>> map = new HashMap<>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.readInputFile();
		// System.out.println(solution.map);
		solution.execute();
		// System.out.println(solution.map);
	}

	public void execute() {
		Set<String> servers = new HashSet<>();
		for (Entry<String, List<SoftwareMetaInfo>> entry : map.entrySet()) {
			Collections.sort(entry.getValue());
			Collections.reverse(entry.getValue());
			String version = null;
			for (SoftwareMetaInfo info : entry.getValue()) {
				if (version == null) {
					version = info.getVersion();
				} else if (!version.equals(info.getVersion())) {
					servers.add(info.getServerName());
				}
			}
		}
		File file = new File("output.txt");
		try (PrintWriter writer = new PrintWriter(file)) {
			for (String serverName : servers)
				writer.println(serverName);
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file to write to ");
			e.printStackTrace();
		}
	}

	private void readInputFile() {
		File file = new File("input.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String inputLine;
			while ((inputLine = reader.readLine()) != null) {

				String[] tokens = inputLine.split(",\\s");

				if (tokens.length == 4) {
					SoftwareMetaInfo softwareMetaInfo = new SoftwareMetaInfo(tokens[2], tokens[1], tokens[3],
							tokens[0]);
					String key = tokens[1] + tokens[2];
					List<SoftwareMetaInfo> values = map.get(key);
					if (values == null) {
						map.put(key, new ArrayList<>());
					}
					map.get(key).add(softwareMetaInfo);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file for reading ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("An exception occurred while reading the file ");
			e.printStackTrace();
		}
	}

	public class SoftwareMetaInfo implements Comparable<SoftwareMetaInfo> {
		private String name;

		private String type;

		private String version;

		private String serverName;

		private Integer major;

		private Integer minor;

		private Integer patch;

		public SoftwareMetaInfo(String name, String type, String version, String serverName) {
			this.name = name;
			this.type = type;
			this.version = version;
			String[] split = version.split("\\.");
			major = Integer.valueOf(split[0]);
			minor = Integer.valueOf(split[1]);
			if (split.length == 3)
				patch = Integer.valueOf(split[2]);
			this.serverName = serverName;
		}

		public String getServerName() {
			return serverName;
		}

		public String getVersion() {
			return version;
		}

		@Override
		public String toString() {
			return "SoftwareMetaInfo [version=" + version + ", serverName=" + serverName + "]";
		}

		@Override
		public int compareTo(SoftwareMetaInfo info) {
			int result = major.compareTo(info.major);
			if (result == 0) {
				result = minor.compareTo(info.minor);
				if (result == 0 && (patch != null)) {
					result = patch.compareTo(info.patch);
				}
			}
			return result;
		}

	}
}
