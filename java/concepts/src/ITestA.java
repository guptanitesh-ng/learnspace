
public interface ITestA extends ITest {

	default String process() {
        return "Process A";
    };
}
