public class PatternController {
	private Pattern model;
	private PatternView view;

	public PatternController(Pattern model, PatternView view) {
		this.model = model;
		this.view = view;
	}

	public void setPatternName(String name) {
		model.setName(name);
	}

	public String getPatternName() {
		return model.getName();
	}

	public void setPatternRollNo(String rollNo) {
		model.setRollNo(rollNo);
	}

	public String getPatternRollNo() {
		return model.getRollNo();
	}

	public void updateView() {
		view.printPatternDetails(model.getName(), model.getRollNo());
	}
}