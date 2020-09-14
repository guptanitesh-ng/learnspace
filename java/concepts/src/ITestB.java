
public interface ITestB extends ITestA {

	default String process() {
        return "Process B";
    };
}
