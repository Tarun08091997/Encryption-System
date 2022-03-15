
public class EncryptionMethods {
	public EncryptionMethods() {}

	
	String CeaserCipher(String INPUT,String KEY) {
		// Check for Empty Input/Key
		
		if(INPUT.isEmpty()) {
			return "Please Insert Input";
		}
		if(KEY.isEmpty()) {
			return "Please Insert Key";
		}
		
		
		
		String PROCESS = "INPUT :"+INPUT+"\nKEY :"+KEY+"\n\nChar\tValueofChar\tKey\tchar+key\t(char+key)mod 26\toutput\n";
		char ch;
		int chvalue;
		int sum;
		int moddedsum;
		int key;
		char outputch;
		boolean upper;
		
		String OUTPUT = "";
		
		
		// Check if key if integer or not
		
		try {
			key = Integer.parseInt(KEY);
			if(!(0<key && key<26)) {
				return "Conditions Unmatched : Please give an Key between 0 and 25";
			}
		}
		catch(Exception ex) {
			
			return "Conditions Unmatched : Please give an Integer Key";  // Condition matched
		}
		
	// create a char and get output for ever character in the INPUT string using for loop
		
		for(int i=0;i< INPUT.length() ; i++) {
			
		    ch = INPUT.charAt(i);  // Character of input string
		    
		    // Character value in integer
		    if('A'<= ch && ch <= 'Z' ) {
		    	chvalue = (int) ch - 'A';
		    	upper = true;
		    }
		    else if('a'<= ch && ch <= 'z') {
		    	chvalue = (int)ch -'a';
		    	upper = false;
		    }
		    else {
		    	return "Conditions unmatched : Please give only alphabetic PLAINTEXT"; // Conditions not matched
		    }
		    
		    // char+key
		    
			sum = chvalue + key;
			
			// (ch+key)mod 26
			
			moddedsum = sum%26;
			
			// output charachter
			if(upper) {
				outputch = (char)((int)(moddedsum + 'A'));
			}
			else {
				outputch = (char)((int)(moddedsum + 'a'));
			}
			
			OUTPUT = OUTPUT + outputch;   // OUTPUT only
			PROCESS = PROCESS +"  "+ ch +"\t  "+ chvalue +"\t"+ key +"  \t"+ sum +"\t    " + moddedsum + "\t\t" + outputch + "\n"; // Process
			
			
		}
		
		PROCESS = PROCESS +"\r\n OUTPUT : "+OUTPUT;
		
		return PROCESS; // Successful operation
	
	}
	
	String AffineCipher(String INPUT,String KEY) {
		// Check for Empty Input/Key
		
				if(INPUT.isEmpty()) {
					return "Please Insert Input";
				}
				if(KEY.isEmpty()) {
					return "Please Insert Key";
				}
		String PROCESS = "";
		char ch;
		int chvalue;
		int sum;
		int moddedsum;
		int A,B;
		char outputch;
		boolean upper;
		
		String OUTPUT = "";
		
		
		// Check if key if integer or not and get value of a and b
		
		try {
			int split = KEY.indexOf(','); // get index of ','
			String a = KEY.substring(0, split);
			String b = KEY.substring(split+1,KEY.length());
			A = Integer.parseInt(a);
			B = Integer.parseInt(b);
			
			if(A%2 == 0 || A == 13) {       // if mod(a,26) == 1
				return "Conditions Unmatched : Please give appropriate values of 'a'";
			}
			if(!(0<B && B<26)) {
				return "Conditions Unmatched : Please give 'b' between 0 and 25";
			}
		}
		catch(Exception ex) {
			
			return "Conditions Unmatched : Please give 'a' , 'b' Integer in form of 'a,b'";  // Condition matched
		}
		
		
		PROCESS = "INPUT :"+INPUT+"\na :"+A + "\nb :"+ B +"\n\nChar\tValueofChar\ta,b\ta*char+b\t(a*char+b)mod 26\toutput\n";
		
	// create a char and get output for ever character in the INPUT string using for loop
		
		for(int i=0;i< INPUT.length() ; i++) {
			
		    ch = INPUT.charAt(i);  // Character of input string
		    
		    // Character value in integer
		    if('A'<= ch && ch <= 'Z' ) {
		    	chvalue = (int) ch - 'A';
		    	upper = true;
		    }
		    else if('a'<= ch && ch <= 'z') {
		    	chvalue = (int)ch -'a';
		    	upper = false;
		    }
		    else {
		    	return "Conditions unmatched : Please give only alphabetic PLAINTEXT"; // Conditions not matched
		    }
		    
		    // a*char+b
		    
			sum = A* chvalue + B;
			
			// (a*char+b)mod 26
			
			moddedsum = sum%26;
			
			// output charachter
			if(upper) {
				outputch = (char)((int)(moddedsum + 'A'));
			}
			else {
				outputch = (char)((int)(moddedsum + 'a'));
			}
			
			OUTPUT = OUTPUT + outputch;   // OUTPUT only
			PROCESS = PROCESS +"  "+ ch +"\t  "+ chvalue +"\t"+ A +","+B +"  \t"+ sum +"\t    " + moddedsum + "\t\t" + outputch + "\n"; // Process
			
			
		}
		
		PROCESS = PROCESS +"\r\n OUTPUT : "+OUTPUT;
		
		return PROCESS; // Successful operation
	
	}

	String SubstitutionCipher(String INPUT,String KEY) {
		String OUTPUT = "";
		String INPUT_SPACED = "";
		String OUTPUT_SPACED = "";
		String character_number = "";
		for(int i=0;i<INPUT.length();i++) {
			char o;
			char ch = INPUT.charAt(i);
			
			if(ch >= 'A' && ch <= 'Z') {
				
				o =  KEY.charAt(ch - 'A');
			}
			else if(ch >= 'a' && ch <= 'z') {
				
				o =  KEY.charAt(ch - 'a'+26);
			}
            else if(ch >= '0' && ch <= '9') {
				
            	o =  KEY.charAt(ch - '0'+52);
			}
            else {
            	return "Conditions Unmatched : Please don't use special charecter in Plain Text";
            }
			
			OUTPUT = OUTPUT + o;
			character_number = character_number + (i+1) +"   ";
			INPUT_SPACED = INPUT_SPACED + ch + "   ";
			OUTPUT_SPACED = OUTPUT_SPACED + o + "   ";
			
		}
		return KEY + "\ncharacter : " +character_number+"\nINPUT       : "+INPUT_SPACED +"\nOUTPUT    : "+OUTPUT_SPACED + "\n\n Thus CIPHER TEXT -> " +OUTPUT;
		
	}
  
	String HillCipher(String INPUT,String KEY) {
		// Check for Empty Input/Key
		
				if(INPUT.isEmpty()) {
					return "Please Insert Input";
				}
				if(KEY.isEmpty()) {
					return "Please Insert Key";
				}
		
		int n = matrixside(KEY.length());
		if(n == -1) {
			return "Conditions Unmatched : Please give proper KEY";
		}
		
		int text_row ;
		if(INPUT.length() % n !=0) {
			return "Conditions Unmatched : Please give proper INPUT";
		}
		else {
			text_row = INPUT.length() / n ;
		}
		
		int KEY_Matrix[][] = new int[n][n];
		String KEYmatrix = "\t\t";
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int pos = n*i +j;
				char ch = KEY.charAt(pos);
				if(ch >= 'A' && ch <= 'Z') {
					KEY_Matrix[i][j] = ch - 'A';
				}
				else if(ch >= 'a' && ch <= 'z') {
					KEY_Matrix[i][j] = ch - 'a';
				}
				else {
					return "Conditions Unmatched : No special character and numbers in KEY";
				}
				
				KEYmatrix = KEYmatrix +" "+ KEY_Matrix[i][j] + "     ";
			}
			KEYmatrix = KEYmatrix + "\n\t\t";
		}
		
		
		
		int INPUT_Matrix[][] = new int[n][text_row];
		String Inputmatrix = "\t\t";
		for(int j=0;j<text_row;j++) {
			for(int i=0;i<n;i++) {
				int pos = n*j + i;
				char ch = INPUT.charAt(pos);
				if(ch >= 'A' && ch <= 'Z') {
					INPUT_Matrix[i][j] = ch - 'A';
				}
				else if(ch >= 'a' && ch <= 'z') {
					INPUT_Matrix[i][j] = ch - 'a';
				}
				else {
					return "Conditions Unmatched : No special character and numbers in INPUT";
				}
				
				
				
			}
			
			
		}
		
		
		int Cout[][] = new int[n][text_row];         // KEY_matrix * INPUT_Matrix
		int OUTPUT_Matrix[][] = new int[n][text_row]; 
		String multiplication = "\t\t";
		String modded_output = "\t\t";
		for(int i=0;i<n;i++) {
			for(int j=0;j<text_row;j++) {
				Cout[i][j] = 0;
				for(int k=0;k<n;k++) {
					Cout[i][j] =Cout[i][j] +  KEY_Matrix[i][k]  * INPUT_Matrix[k][j];
				}
				OUTPUT_Matrix[i][j] = Cout[i][j] % 26 ;
			}
		}
		
		String CYPHER_TXT = "";
		
		for (int i=0;i<n;i++) {
			for(int j=0;j< text_row;j++){
				
				CYPHER_TXT = CYPHER_TXT + (char)('A'+ OUTPUT_Matrix[i][j])+" ";
				multiplication = multiplication + "  " + Cout[i][j] + "  ";
				modded_output = modded_output + "  " + OUTPUT_Matrix[i][j] + " ";
				Inputmatrix = Inputmatrix + "  "+ INPUT_Matrix[i][j] +"  ";
			}
			multiplication = multiplication + "\n\t\t";
			modded_output = modded_output + "\n\t\t"; 
			Inputmatrix = Inputmatrix + "\n\t\t";
		}
		return "KEY : " + KEY + "\nINPUT :" + INPUT + "\n\nKEY MATRIX :\n"+KEYmatrix + "\nINPUT MATRIX : \n"+Inputmatrix +"\nKEY MATRIX  * INPUT MATRIX  :\n"+multiplication+"\n(K*I)MOD26 :\n"+modded_output+"\n\n CYPHER TEXT : " + CYPHER_TXT ;
	}
				
		int matrixside(int KEY) {
			int n ;
			double l =Math.sqrt((double)KEY);
			if(l - Math.floor(l) == 0) {
				n = (int)l;
			}
			else {
				return -1;
			}
			return n;
		}
	String PlayFairCipher(String INPUT,String KEY) {
		
		// Replace all J with I
		
		String Add_Key = "ABCDEFGHIKLMNOPQRSTUVWXYZ";
		String Unique_key="";
		// Check for Empty Input/Key
		
				if(INPUT.isEmpty()) {
					return "Please Insert Input";
				}
				if(KEY.isEmpty()) {
					return "Please Insert Key";
				}
////////////////////////////////////////////////////////KEY?///////////////////////////////
				
				
		// Create Unique key code of 25 alphabets
				for(int i=0;i<KEY.length();i++) {
					char ch = KEY.charAt(i);
					boolean original = true;
					if(ch>= 'A' && ch<= 'Z') {
						if(ch == 'J') {
							ch = 'I';
						}
						
					}
					else if(ch>= 'a' && ch<= 'z') {
						ch = (char)(ch-'a'+'A');
						if(ch == 'J') {
							ch = 'I';
						}
					}
					else {
						return "Conditions Unmatched : Please give a proper Key with only alphabets as Input";
					}
					
					if(Unique_key.length() == 0) {
						Unique_key = Unique_key + ch;
						Add_Key = Add_Key.substring(0, Add_Key.indexOf(ch)) + Add_Key.substring(Add_Key.indexOf(ch) + 1);
					}
					else {
						// Check if ch is original or copy character in Unique_key
						for(int j=0;j<Unique_key.length();j++) {
							if(ch == Unique_key.charAt(j)) {
								original = false;
								break;
							}							
						}
						if(original) {
							Unique_key = Unique_key + ch;
							
							Add_Key = Add_Key.substring(0, Add_Key.indexOf(ch)) + Add_Key.substring(Add_Key.indexOf(ch) + 1);
						}
					}
				}
				
				
				Unique_key = Unique_key + Add_Key;   // Full 25 Character KEY + remaining all
				
				
				//////////////////////////////////////////////////////// INPUT////////////////////////
				String Changed_INPUT = "";
				for(int i=0;i<INPUT.length();i++) {
					char ch = INPUT.charAt(i);
					if(ch>= 'A' && ch<= 'Z') {
						if(ch == 'J') {
							ch = 'I';
						}
						
					}
					else if(ch>= 'a' && ch<= 'z') {
						ch = (char)(ch-'a'+'A');
						if(ch == 'J') {
							ch = 'I';
						}
					}
					else {
						return "Conditions Unmatched : Please give a proper Key with only alphabets as Input";
					}
					
				Changed_INPUT = Changed_INPUT + ch;
				}
				
				
				
				
				// Use condition on input
				boolean no_repeat = false;
				while(!no_repeat) {
					int i =0;
					
					//1. Check if grouping of two letters have same character if yes then change them if not and String is odd add 'Z'
					
					INPUT = Changed_INPUT;
					for(i=0;i<INPUT.length();i=i+2) {
						if(i != (INPUT.length()-1)) {
							if(INPUT.charAt(i) == INPUT.charAt(i+1)) {
								no_repeat = false;
								break;
							}
							else {
								no_repeat = true;
							}
						}
						else {
							
								Changed_INPUT = Changed_INPUT + ('Z'+"");
								no_repeat = true;
							
						}
					}
					
					if(!no_repeat) {
			
					    Changed_INPUT =  Changed_INPUT.substring(0,i+1) +  'X'+ Changed_INPUT.substring(i+1);
					}}
				
				// Create KEY matrix
				
				char KEY_MATRIX[][]= new char[5][5];
				String Keymatrix = "\t\t";
				
				for(int i=0;i< 5;i++) {
					for(int j=0;j<5;j++) {
						KEY_MATRIX [i][j] = Unique_key.charAt(i*5 +j);
						Keymatrix = Keymatrix + ' ' + KEY_MATRIX [i][j] + ' ';
					}
					Keymatrix = Keymatrix + "\n\t\t" ;
				}
				
				// Create OUTPUT
				
				String OUTPUT = "";
				String process = " \n\rPROCESS : \n";
				for(int k=0;k<Changed_INPUT.length();k=k+2) {
					char ch1 = Changed_INPUT.charAt(k);
					char ch2 = Changed_INPUT.charAt(k+1);
					process = process + "\n\n\t" + ch1 + ch2;
					int i1=0,j1=0,i2=0,j2=0;
					for(int i=0;i<5;i++) {
						for(int j=0;j<5;j++) {
							if(KEY_MATRIX[i][j] == ch1) {
								i1 = i;
								j1 = j;
							}
							else if(KEY_MATRIX[i][j] == ch2) {
								
								i2 = i;
								j2 = j;
							}
						}
					}
					
					process = process + "   "+ch1 +": in row,column: "+i1+","+j1 +"   "+ ch2+": in row,column: "+i2+","+j2 +"\n\t  ";
					
					
					
					// Rule 1
					if(i1 == i2) {
						process = process + "Using Rule : 1 -> ";
						if(j1 == 4) {
							j1 =0;
						}
						else {
							j1 = j1+1;
						}
						if(j2 == 4) {
							j2 =0;
						}
						else {
							j2 = j2+1;
						}
						
					}
					// Rule 2
					else if(j1 == j2) {
						process = process + "Using Rule : 2 -> ";
						if(i1 == 4) {
							i1 =0;
						}
						else {
							i1 = i1+1;
						}
						if(i2 == 4) {
							i2 =0;
						}
						else {
							i2 = i2+1;
						}
						
					}
					// Rule 3
					else {
						process = process + "Using Rule : 3 -> ";
						j1 = j1 + j2;
						j2 = j1-j2;
						j1 = j1 - j2;
					}
					
					OUTPUT = OUTPUT + KEY_MATRIX[i1][j1]  + KEY_MATRIX[i2][j2]+ " ";
					process = process + KEY_MATRIX[i1][j1]  + KEY_MATRIX[i2][j2];
				}
				
				
		return "KEY : " + KEY +"\nINPUT : " + INPUT + "\n PLAINTEXT : "+ Changed_INPUT + "\nKEY MATRIX :" + Keymatrix +  process + "\n\nOUTPUT :" + OUTPUT;
	}

	String VignereCipher(String INPUT,String KEY) {
		
		String new_key = "";  // key with same length as Input
		String OUTPUT = "";
		String PROCESS = "";
		
		// Check for empty input
		if(INPUT.isEmpty()) {
			return "Please Insert Input";
		}
		if(KEY.isEmpty()) {
			return "Please Insert Key";
		}
		
		// Check condition 1
		if(KEY.length() > INPUT.length()) {
			return " Length of KEY should be smaller than Length of  INPUT String";
		}
		
		// CHECK INPUT
		for(int i =0;i<INPUT.length();i++) {
			char ch = INPUT.charAt(i);
			if(ch>= 'A' && ch<= 'Z') {
				
			}
			else if(ch>= 'a' && ch<= 'z') {
				ch = (char)(ch-'a'+'A');
				INPUT = INPUT.substring(0,i) + ch + INPUT.substring(i+1);
			}
			else {
				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
			}
			
		}
		
		// Check Key
		for(int i =0;i<KEY.length();i++) {
			char ch = KEY.charAt(i);
			if(ch>= 'A' && ch<= 'Z') {
				
			}
			else if(ch>= 'a' && ch<= 'z') {
				ch = (char)(ch-'a'+'A');
				KEY = KEY.substring(0,i) + ch + KEY.substring(i+1);
			}
			else {
				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
			}
			
		}
		
		if(INPUT.length() > KEY.length()) {
			int r = INPUT.length()/KEY.length();  // Number of repeats
			int c = INPUT.length() % KEY.length(); // Number of character added
			
			new_key = KEY.repeat(r)+KEY.substring(0,c);
		}
		else {
			new_key = KEY;
		}
		
		
		for(int i=0;i<INPUT.length();i++) {
			char ch1 = INPUT.charAt(i);
			char ch2 = new_key.charAt(i);
			int a = ch1 - 'A';
			int b = ch2 -'A';
			int o = a+b;
			int mod = o % 26;
			
			char out = (char)(mod+'A');
			OUTPUT = OUTPUT + out;
			PROCESS = PROCESS + ch1 +"\t   " + a+" \t" +ch2+"\t   "+b+"  \t"+o+"  \t       "+ mod +"\t    "+ out + "\n";			
			 
		}
		
		PROCESS = PROCESS + "\n\nThus OUTPUT : " + OUTPUT;
		
		
		
		
		
		return "INPUT :"+INPUT+"\nKEY :"+KEY+"\nKEY Used for Encryption :"+new_key+"\n\nChar\tChar Value\tKey\tKey value\tc+k\t(c+k)mod 26\toutput\n" + PROCESS;
	}

    String VernamCipher(String INPUT,String KEY) {
    	 

 		String OUTPUT = "";
 		String PROCESS = "";
 		
 		// Check for empty input
 		if(INPUT.isEmpty()) {
 			return "Please Insert Input";
 		}
 		if(KEY.isEmpty()) {
 			return "Please Insert Key";
 		}
 		
 		
 		if(INPUT.length() != KEY.length()) {
 			return "KEY length sould be equal to INPUT length";
 		}
 		
 		
 		// CHECK INPUT
 		for(int i =0;i<INPUT.length();i++) {
 			char ch = INPUT.charAt(i);
 			if(ch>= 'A' && ch<= 'Z') {
 				
 			}
 			else if(ch>= 'a' && ch<= 'z') {
 				ch = (char)(ch-'a'+'A');
 				INPUT = INPUT.substring(0,i) + ch + INPUT.substring(i+1);
 			}
 			else {
 				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
 			}
 			
 		}
 		
 		// Check Key
 		for(int i =0;i<KEY.length();i++) {
 			char ch = KEY.charAt(i);
 			if(ch>= 'A' && ch<= 'Z') {
 				
 			}
 			else if(ch>= 'a' && ch<= 'z') {
 				ch = (char)(ch-'a'+'A');
 				KEY = KEY.substring(0,i) + ch + KEY.substring(i+1);
 			}
 			else {
 				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
 			}
 			
 		}
 		
 		
 		
 		for(int i=0;i<INPUT.length();i++) {
 			char ch1 = INPUT.charAt(i);
 			char ch2 = KEY.charAt(i);
 			int a = ch1 - 'A';
 			int b = ch2 -'A';
 			int o = a^b;
 			int mod = o % 26;
 			
 			char out = (char)(mod+'A');
 			OUTPUT = OUTPUT + out;
 			PROCESS = PROCESS + ch1 +"\t   " + a+" \t" +ch2+"\t   "+b+"  \t"+o+"  \t       "+ mod +"\t    "+ out + "\n";			
 			 
 		}
 		
 		PROCESS = PROCESS + "\n\nThus OUTPUT : " + OUTPUT;
 		
 		
 		
 		
 		
 		return "INPUT :"+INPUT+"\nKEY :"+KEY+"\n\nChar\tChar Value\tKey\tKey value\tc+k\t(c xor k)mod 26\toutput\n" + PROCESS;
 	
      }
     
    String AutoKey(String INPUT,String KEY) {
    
    	String new_key = "";  // key with same length as Input
		String OUTPUT = "";
		String PROCESS = "";
		
		// Check for empty input
		if(INPUT.isEmpty()) {
			return "Please Insert Input";
		}
		if(KEY.isEmpty()) {
			return "Please Insert Key";
		}
		
		// Check condition 1
		if(KEY.length() > INPUT.length()) {
			return " Length of KEY should be smaller than Length of  INPUT String";
		}
		
		// CHECK INPUT
		for(int i =0;i<INPUT.length();i++) {
			char ch = INPUT.charAt(i);
			if(ch>= 'A' && ch<= 'Z') {
				
			}
			else if(ch>= 'a' && ch<= 'z') {
				ch = (char)(ch-'a'+'A');
				INPUT = INPUT.substring(0,i) + ch + INPUT.substring(i+1);
			}
			else {
				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
			}
			
		}
		
		// Check Key
		for(int i =0;i<KEY.length();i++) {
			char ch = KEY.charAt(i);
			if(ch>= 'A' && ch<= 'Z') {
				
			}
			else if(ch>= 'a' && ch<= 'z') {
				ch = (char)(ch-'a'+'A');
				KEY = KEY.substring(0,i) + ch + KEY.substring(i+1);
			}
			else {
				return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
			}
			
		}
		
		if(INPUT.length() > KEY.length()) {			
			new_key = KEY + INPUT.substring(0,INPUT.length()-KEY.length());
		}
		else {
			new_key = KEY;
		}
		
		
		for(int i=0;i<INPUT.length();i++) {
			char ch1 = INPUT.charAt(i);
			char ch2 = new_key.charAt(i);
			int a = ch1 - 'A';
			int b = ch2 -'A';
			int o = a+b;
			int mod = o % 26;
			
			char out = (char)(mod+'A');
			OUTPUT = OUTPUT + out;
			PROCESS = PROCESS + ch1 +"\t   " + a+" \t" +ch2+"\t   "+b+"  \t"+o+"  \t       "+ mod +"\t    "+ out + "\n";			
			 
		}
		
		PROCESS = PROCESS + "\n\nThus OUTPUT : " + OUTPUT;
		
		
		
		
		
		return "INPUT :"+INPUT+"\nKEY :"+KEY+"\nKEY Used for Encryption :"+new_key+"\n\nChar\tChar Value\tKey\tKey value\tc+k\t(c+k)mod 26\toutput\n" + PROCESS;
	
    }
    
    String ColumnTransposition(String INPUT,String KEY) {
    	
    	String add_key = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
    	// Check for Empty Input/Key
    	String PROGRESS="";
		
    	if(INPUT.isEmpty()) {
    		return "Please Insert Input";
    	}
    	if(KEY.isEmpty()) {
    	    return "Please Insert Key";
    	}
    			
    	if(INPUT.length()<KEY.length()) {
    		return "Key length should be smaller than PlainText";
    	}
    	
    	// Check Key
    	for(int i =0;i<KEY.length();i++) {
    		char ch = KEY.charAt(i);
    		if(ch>= 'A' && ch<= 'Z') {
    			
    		}
    		else if(ch>= 'a' && ch<= 'z') {
    			ch = (char)(ch-'a'+'A');
    			KEY = KEY.substring(0,i) + ch + KEY.substring(i+1);
    		}
    		else {
    			return "Conditions Unmatched : Please give a proper INPUT with only alphabets as Input";
    		}}
    	
    	String KEY_Value = "0";
    	KEY_Value = KEY_Value.repeat(KEY.length());
    	
    	int value = 1;
    	for(int i=0;i<KEY.length();i++) {
    		int index = 0;
    		while(index <KEY.length()-1 && (KEY_Value.charAt(index) != '0')) {
    			index++;
    		}
    		int min = (int) KEY.charAt(index);
    		for(int j=0;j<KEY.length();j++) {
    			if(min > (int)KEY.charAt(j) && (KEY_Value.charAt(j) == '0')) {
    				min = (int)KEY.charAt(j);
    				index = j;
    			}
    			else if(index != j && KEY.charAt(index) == KEY.charAt(j)) {
    				return "Every Character in KEY should be diffrent";
    			}
    		}
    		KEY_Value = KEY_Value.substring(0,index)+value + KEY_Value.substring(index+1);
    		value++;
    	}
    	
    	int columns = KEY.length();
    	int rows;
    	if(INPUT.length() % columns==0) {
    		rows =(INPUT.length()/columns);
    	}
    	else {
    		rows = (INPUT.length()/columns) + 1;
    		
    		int d = INPUT.length() % columns;
    		d = columns-d;
    		String extra = add_key.substring(0,d);
    		String reverse="";
    		for(int l=(extra.length()-1);l>=0;l--) {
    			reverse = reverse+extra.charAt(l);
    		}
    		INPUT = INPUT+reverse ;
    	}
    	
    	int index_of=0;
    	String Cipher_matrix="\t\t";
    	for (int i=0;i<KEY.length();i++) {
    		Cipher_matrix = Cipher_matrix + KEY_Value.charAt(i) + "  ";
    	}
    	Cipher_matrix = Cipher_matrix + "\n\t\t";
    	
    	
    	char matrix[][] = new char[rows][columns];
    	for (int i=0;i<rows;i++){
    		for(int j=0;j<columns;j++) {
    			matrix[i][j] = INPUT.charAt(i*columns+j);
    			Cipher_matrix = Cipher_matrix + matrix[i][j] +"  ";
    			
    		}
    		Cipher_matrix = Cipher_matrix +"\n\t\t";
    		
    	}
    	
    	
    	String OUTPUT = "";
    	for(int t=0;t<KEY.length();t++) {
    		int column_index=0;
    		for(int s=0;s<KEY.length();s++) {
    			char ch = KEY_Value.charAt(s);
    			if(ch-'1' == t) {
    			    column_index = s;
    			    break;
    		}}
    		for(int i=0;i<rows;i++) {
    			OUTPUT = OUTPUT + matrix[i][column_index];
    		}
    		OUTPUT = OUTPUT +" ";
    	}
    	
    	
    	return "INPUT :"+INPUT+"\n\rKEY :" + KEY +"\n\rKEY Value :"+ KEY_Value + "\nCipher Matrix :  "+"("+rows+"x"+columns+")\n"+Cipher_matrix + "\n\nCipher Text :"+OUTPUT;
    }

     String RailFance(String INPUT,String KEY) {
    	 
    	 int key;
    	 
    	 if(INPUT.isEmpty()) {
 			return "Please Insert Input";
 		}
 		if(KEY.isEmpty()) {
 			return "Please Insert Key";
 		}
 		
 		
    	 
    	 
    	 try {
 			key = Integer.parseInt(KEY);
 			if(1 >= key) {
 				return "Conditions Unmatched : Please give an Key > 1";
 			}
 		}
 		catch(Exception ex) {
 			
 			return "Conditions Unmatched : Please give an Integer Key";  // Condition matched
 		}
    	 
    	 
    	 if(key > INPUT.length()) {
    		 return "Key should be smaller then Input Length";
    	 }
    	 
    	 
    	 String OUTPUT ="";
    	 String matrix = "\n\t\t";
    	 char Matrix[][] = new char[key][INPUT.length()];
    	 for(int i = 0;i<key;i++) {
    		 for(int j =0;j<INPUT.length();j++) {
    			 Matrix[i][j] = '|';
    		 }
    	 }
    	 
    	 // number of rows = Keys
    	 int index = 0;
    	 int row = -1;
    	 int column = -1;
    	 boolean down = true;
    	 while(index < INPUT.length()) {
    		 // if downward then row ++ else row-- 
    		 // always column ++
    		 
    		 
    		 if(down && row != key-1) {
                  row++;
                  column++;
                  Matrix[row][column] = INPUT.charAt(index);
                  index++;
    			 }
    		 
    		 else if(down && row == key-1) { 
    			 down = false ;
    			 }
    			 
    		 else if(!down && row != 0) { 
    			 row--;
    			 column++;
    			 
    			 Matrix[row][column] = INPUT.charAt(index);
    			 index++;
    			 }
    		 else {
    			 down = true;
    		 }
    		 
    		 }
    	 
    	 for(int i = 0;i<key;i++) {
    		 for(int j =0;j<INPUT.length();j++) {
    			if(Matrix[i][j] != '|') {
    				OUTPUT = OUTPUT + Matrix[i][j];
    				matrix = matrix + Matrix[i][j];
    			}
    			else {
    				matrix = matrix + "  ";
    			}
    			
    		 }
    		 matrix = matrix + "\n\t\t";
    	 }
    	 
    	 return "INPUT :" +INPUT + "\nkey :" + KEY + "\nRailFance :" + matrix + "\n\rOUTPUT :" + OUTPUT;
     }
 
     
}


