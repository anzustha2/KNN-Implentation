public class Passenger
{
   private String name;
   private double fare;
   private int pClass;
   private int gender;
   private String fate;
   
   public Passenger(String[] arr)
   {      
      String nameOld = arr[0]; 
		int check = -1; 
		int check2 = -1; 
		String temp = ""; 
		String firstName = ""; 
		String lastName = ""; 
		for(int i = 0; i < nameOld.length(); i++){
			temp = nameOld.charAt(i) + ""; 
			if(temp.matches("[A-Z]")){
				if(check == -1){
					lastName = nameOld.charAt(i) + "";
					check = 0; 
				}
				else if(check == 0){
					firstName = nameOld.charAt(i) + "";
					check2 = 0;
					check = -1; 
				}
			}
			else if(temp.matches("[a-z]") && check == 0){
				lastName = lastName + nameOld.charAt(i); 
			}

			else if(temp.matches("[a-z]") && check2 == 0){
				firstName = firstName + nameOld.charAt(i); 
			}
		}
      
		String name = "";
		name = firstName + " " + lastName;
		this.name = name; 
		this.fare = Double.parseDouble(arr[1]);
		String arr2 = arr[2]; 
		if(arr2.matches("First"))
      {
			arr[2] = "1";
		}
		else if(arr2.matches("Second"))
      {
			arr[2] = "2";
		}
		else if(arr2.matches("Third"))
      {
			arr[2] = "3";
		}
		this.pClass = Integer.parseInt(arr[2]);
		String arr3 = arr[3]; 
		if(arr3.matches("Male"))
      {
			arr[3] = "0";
		}
		else if(arr3.matches("Female"))
      {
			arr[3] = "1";
		}
		this.gender = Integer.parseInt(arr[3]);
      
      if(arr.length == 5)
         this.fate = arr[4];
		
	}
	
   public void setFate(String arr)
   {
      this.fate = arr;
   }
   
	
	public String getName()
   {
		return this.name; 
	}
	
	public double getFare()
   {
		return this.fare; 
	}
	
	public int getPClass()
   {
		return this.pClass;
	}
	
	public int getGender()
   {
		return this.gender;
	}
	
	public String getFate()
   {
		return this.fate; 
	}
   
}
      