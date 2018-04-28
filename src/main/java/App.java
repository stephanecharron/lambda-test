import java.lang.reflect.Field;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
	public static void main (String [] args) throws NoSuchFieldException, IllegalAccessException {
		Pojo pojo = new Pojo();
		pojo.foo1 = "f1";
		pojo.foo2 = "f2";

		Map<String, String > map = Stream.of(pojo.getClass()
				.getFields())
				.collect(Collectors.toMap(Field::getName, Field::getName));

		System.out.println(pojo.getClass().getField("foo1").get(pojo));
		System.out.println(map);

	}
}
