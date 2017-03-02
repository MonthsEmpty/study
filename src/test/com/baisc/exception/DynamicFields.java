package test.com.baisc.exception;

public class DynamicFields {

	private Object[][] fields;
	
	public DynamicFields(int initialSize) {
		fields = new Object[initialSize][2];
		for(int i = 0 ; i < initialSize ; i++ ){
			fields[i] = new Object[]{null,null};
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for(Object[] object : fields){
			result.append(object[0]);
			result.append(": ");
			result.append(object[1]);
			result.append("\n");
		}
		return result.toString();
	}
	
	private int hasField(String id){
		for(int i = 0; i < fields.length;i++){
			if(id.equals(fields[i][0])){
				return i;
			}
		}
		return -1;
	}
	
	private int getFieldNumber(String id) throws NoSuchFieldException {
		int fieldNum = hasField(id);
		if(fieldNum == -1){
			throw new NoSuchFieldException();
		}
		return fieldNum;
	}
	
	private int makeField(String id){
		for(int i = 0; i < fields.length; i++){
			if(fields[i][0] == null){
				fields[i][0] = id;
				return i;
			}
		}
		// No empty fields . Add one:
		Object[][] temp = new Object[fields.length + 1][2];
		for(int i = 0 ; i < fields.length ; i++){
			temp[i] = new Object[]{null,null};
		}
		fields = temp;
		return makeField(id);		
	}
}
