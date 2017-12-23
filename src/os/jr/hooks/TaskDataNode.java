package os.jr.hooks;

public class TaskDataNode extends Node {

	public TaskDataNode(Object reference) {
		super(Hooks.classNames.get("Task"));
		this.reference = reference;
	}

}
