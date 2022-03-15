
public class lol {

	public static void main(String[] args) {
		String KEY="tarun";
		String KEY_Value = "0";
    	KEY_Value = KEY_Value.repeat(KEY.length());
    	
    	int value = 1;
    	for(int i=0;i<KEY.length();i++) {
    		int index = 0;
    		while(index <KEY.length()-1 && (KEY_Value.charAt(index) != '0')) {
    			if((KEY_Value.charAt(index) != '0')) {
    				System.out.println("lol");
    			}
    			index++;
    			System.out.println(index);
    		}
    		int min = (int) KEY.charAt(index);
    		for(int j=0;j<KEY.length();j++) {
    			if(min > (int)KEY.charAt(j) && (KEY_Value.charAt(j) == '0')) {
    				min = (int)KEY.charAt(j);
    				index = j;
    			}    			
    		}
    		KEY_Value = KEY_Value.substring(0,index)+value + KEY_Value.substring(index+1);
    		value++;
    	}

	}

}
