package concepts;

import static java.lang.System.out;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String args[]) {
		//System.out.println(ZoneId.getAvailableZoneIds());
		ZoneId.getAvailableZoneIds().stream().filter(z -> z.contains("Delhi")).forEach(f -> out.println(f));
		
		Set<List<String>> set=new HashSet<>();
		List<String> list = new ArrayList<>();
		list.add("w");
		list.add("w");
		list.add("w");
		list.add("z");
		list.add("z");
		set.add(list);
		list = new ArrayList<>(list);
		set.add(list);
		
		set.forEach(e -> System.out.println(e.toString()));
	}

	int fun() {
		return 20;
	}
}