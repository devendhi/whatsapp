import java.util.Scanner;
import java.util.ArrayList;
import java. util. Iterator;
import java.util.HashMap;
import java.util.Map;
class Contact{
		 int ContactId=0;
		private String ContactName;
		private long ContactNumber;
		static HashMap<Integer,Contact> AllContactDetails = new HashMap<Integer, Contact>();
		

		public void setContactName(String name){
				this.ContactName=name;
		}
		public String getContactName(){
			return ContactName;
		}
		public void setContactNumber(long number){
				this.ContactNumber=number;
		}
		public long getContactNumber(){
			return ContactNumber;
		}
		public int contactId(){
			ContactId=ContactId+1;
			return ContactId;
		}

		public void AddContact(String Cname,long Cnumber){
			Contact newcontact=new Contact();
			newcontact.setContactName(Cname);
			newcontact.setContactNumber(Cnumber);
			AllContactDetails.put(contactId(),newcontact);
			
			System.out.println("NewContact Added NewContact Id ="+ContactId);
		}
		public void ShowAllDelais(){
					if(AllContactDetails.size()>0){
							for (int key: AllContactDetails.keySet()) {
					  			 Contact particularvalueobject=AllContactDetails.get(key);
								System.out.println("ID: " + key+" " +"Name :"+particularvalueobject.getContactName()+" "+"Number :"+particularvalueobject.getContactNumber());
					    
								}

					}else {
						System.out.println("No contacts.......");
					}

					 
				
		}
		public void ShowParticularId(int id){
					Contact particularvalueobject=AllContactDetails.get(id);
					System.out.println("Name ="+particularvalueobject.getContactName()+" "+"Number ="+particularvalueobject.getContactNumber());
		}
		public void DeleteAllContact(){
					System.out.println("All contacts cleard......");
					AllContactDetails.clear();
		}
		public void DeleteParticularId(int id){	
							 ShowParticularId(id);					
					 		 AllContactDetails.remove(id);
							 System.out.println("Contact deletected......");							
					
		}
		public void ChanchingContact(int id, String newname,long newnumber ){
			System.out.println("Old contact details:");
					ShowParticularId(id);
					System.out.println();

					Contact newcontact=new Contact();
					newcontact.setContactName(newname);
					newcontact.setContactNumber(newnumber);
					AllContactDetails.put(id,newcontact);

					System.out.println("New contact details:-");
					ShowParticularId(id);

		}

}
class Chats extends Contact{
			 Message messageobj= new Message();
			private int Chatid=0; 
			static HashMap<Integer,Integer> ChatDetails=new HashMap<Integer,Integer>();

			public int Chatid(){
					Chatid=Chatid+1;	
					return Chatid;
			}
			
			public void AddParticularId(int cid,String message){

						if(AllContactDetails.size()>0 && AllContactDetails.containsKey(cid)!=false){

								if(ChatDetails.size()>0 && ChatDetails.containsKey(cid)!=false){		
										
										int chatid=ChatDetails.get(cid);
										 messageobj.AddMessage(chatid,message);
										
								}else{								
										
										 ChatDetails.put(cid,Chatid());
										 int chatid=ChatDetails.get(cid);										
										 messageobj.AddMessage(chatid,message);
								}							
									
						}else{

							System.out.println("pleace enter the correct contact id........");
						}
			}
			public void ShowParticularchatmessage(int cid){
						if(AllContactDetails.size()>0 && AllContactDetails.containsKey(cid)!=false){
								if(ChatDetails.size()>0 && ChatDetails.containsKey(cid)!=false){									
										int chatid=ChatDetails.get(cid);
										messageobj.ShowpadiculareContactMessage(chatid);
								}else{
									System.out.println("pleace enter the correct contact id........");
								}

										
						}else{
								System.out.println("pleace enter the correct contact id........");
						}
			} 
			public void ShowAllchatmessages(){
					if(ChatDetails.size()>0){
						 messageobj.ShowAllMessages();
					}				

			}
			public void DeleteAllChats(){
				if(ChatDetails.size()>0){
					ChatDetails.clear();
					messageobj.RemoveAllMessage();
					System.out.println("All Chats deletected......");			

				}
					
			 }
			public void DeletepardicularChats(int id){
				System.out.println("one Chats deletected......");
				 if(ChatDetails.containsKey(id)!=false){
				 	messageobj.RemovePardicularChatsMessage(ChatDetails.get(id));
				 	ChatDetails.remove(id);
					System.out.println("Chat deletected......");;
				 }else{
				 	System.out.println("This id not ivolve in Your contact..........");
				 }
				

			}
			public void DeletepardicularMessage(int id,String massage){
						if(AllContactDetails.size()>0 && AllContactDetails.containsKey(id)!=false){
								if(ChatDetails.size()>0 && ChatDetails.containsKey(id)!=false){									
										int chatid=ChatDetails.get(id);
										 messageobj.Deletemassage(chatid,massage);
								}else{
									System.out.println("pleace enter the correct contact id........");
								}

										
						}

			}

}
class Message {
			
			static 	HashMap<Integer,ArrayList<String>> MessageList =new HashMap<Integer,ArrayList<String>>();
			public static void AddMessage(int id,String message){					
								if(MessageList.size()>0 && MessageList.containsKey(id)!=false){																
										MessageList.get(id).add(message);										
										System.out.println("message sended.......");
										
								}else{
										ArrayList<String> emty=new ArrayList<>();
										emty.add(message);
										MessageList.put(id,emty);						
										System.out.println("message sended.......");										
								}		
			}
			public static void ShowpadiculareContactMessage(int chatid){

						ArrayList<String> values=MessageList.get(chatid);
									for(String words:values){
										System.out.println(words+" ");
									}
									System.out.println();
									System.out.println("Last Massega for this id:"+ values.get(values.size()-1));
										
			}
				
					
			
			public static void ShowAllMessages(){
				if(MessageList.size()>0){


						for(Map.Entry<Integer,ArrayList<String>>  entry:MessageList.entrySet()){
								Integer key=entry.getKey();

								System.out.print("id :"+key+" \nvalue :");
								ArrayList<String> values=entry.getValue();
								for(String words:values){
									System.out.println(words+" ");
								}					
						}
				}
			}
			public void RemoveAllMessage(){
				if(MessageList.size()>0){
					MessageList.clear();	
				}else{
					System.out.println("All ready messages Emty");
				}
			}
			public void RemovePardicularChatsMessage(int chatid){
						if(MessageList.containsKey(chatid)){
								MessageList.remove(chatid);
						}
			}
			 public void Deletemassage(int chatid,String massage){
								ArrayList massagelist=(ArrayList)MessageList.get(chatid);
								massagelist.remove(massage);
								System.out.println("massage Deleted.......");
			}

}
class Status{
				
				static 	HashMap<Integer,ArrayList<String>> ContactStatusDetails =new HashMap<Integer,ArrayList<String>>();
				static 	HashMap<Integer,String> MyStatusDetails =new HashMap<Integer,String>();
				public int NumberOfMyStatus(){
						int count=MyStatusDetails.size()+1;
						return count;
				}

				public  void AddMystatus(String text){
					System.out.println(text);
					System.out.println(NumberOfMyStatus());
					MyStatusDetails.put(NumberOfMyStatus(),text);
					System.out.println("status added.....");
				}
				public void GetMayStatus(){
					System.out.println("My Status:-");
					for(int statusid=0;statusid<MyStatusDetails.size();statusid++){
								System.out.println("status Id"+statusid+" "+"Status:"+MyStatusDetails.get(statusid));
					}
				}


}

class MapingClass extends Message {
		static Contact contactobj=new Contact();
		static Chats chatobj=new Chats();
		static Status statusobj=new Status();		
		public static void ProcessComment(String url){						
						String[] splitbyspace=url.split(" ");
						
						if(splitbyspace[0].equals("get")){
								String[] splitbyslace=splitbyspace[1].split("/");
								if(splitbyslace.length >0 && splitbyslace[0].equals("contacts")){

									if(splitbyslace.length ==2){
										int particulareid=Integer.parseInt(splitbyslace[1]);
											contactobj.ShowParticularId(particulareid);
									}else if(splitbyslace.length ==1){
									    	contactobj.ShowAllDelais();
									}else{
												System.out.println("Rong URl.........");
										}

								}else if(splitbyslace.length >0 && splitbyslace[0].equals("chats")){
											
													if(splitbyslace.length ==2){
														int particulareid=Integer.parseInt(splitbyslace[1]);
															 chatobj.ShowParticularchatmessage(particulareid);
													}else if(splitbyslace.length ==1){
													    	chatobj.ShowAllchatmessages();
													}
													else{
																System.out.println("Rong URl.........");
													}		

								}else if(splitbyslace.length >0 && splitbyslace[0].equals("status")){

											if(splitbyslace.length ==2){
														System.out.println("cid"+splitbyslace[1]);
											}else if(splitbyslace.length ==1){
													    	System.out.println("Show all MyStatus only......	");
											}
											else{
																System.out.println("Rong URl.........");
											}	


								}

						}else if(splitbyspace[0].equals("post")){
									
								String[] posturl=splitbyspace[1].split("=|\\&");

								String[] posturilresource=posturl[0].split("/");
								
								if(posturilresource[0].equals("contacts")){
											if(posturl[1].length() > 0 && posturl[3].length()==10){
														contactobj.AddContact(posturl[1],Long.parseLong(posturl[3]));
														
											}
											else{
												System.out.println("Enter the correct Name & And 10 digit PhoneNumber........");
											}
									
								}else if(posturilresource[0].equals("chats")){
									
									if(posturilresource.length == 3 ){

													int ChatingcontactId=Integer.parseInt(posturilresource[1]);
													String Message=posturilresource[2];
													
													chatobj.AddParticularId(ChatingcontactId,Message);

									}else{
										System.out.println("Pleace enter the correct url...");
									}
									
					 		}else if(posturilresource[0].equals("status")){
					 						if(posturilresource.length == 3){
					 									System.out.println("status texts="+posturilresource[2]);
					 									System.out.println("status id"+posturilresource[1]);
					 						}else if(posturilresource.length == 2){					 								
					 									statusobj.AddMystatus(posturilresource[1]);
					 						}else{
					 							System.out.println("Rong url......");
					 						}

					 		}
					 		else {
					 			System.out.println("Something wend to rong.......");
					 		}
						}else if(splitbyspace[0].equals("delete")){
										System.out.println(splitbyspace[1]);
										String[] deltecontect=splitbyspace[1].split("/");
										if(deltecontect[0].equals("contacts")){

											if(deltecontect.length ==2 &&deltecontect[0].equals("contacts") ){														
														contactobj.DeleteParticularId(Integer.parseInt(deltecontect[1]));		
												}else if(deltecontect.length ==1 &&deltecontect[0].equals("contacts")){
																contactobj.DeleteAllContact();
												}

										}else if(deltecontect[0].equals("chats")){

												if(deltecontect.length ==3 ){														
												 		chatobj.DeletepardicularMessage(Integer.parseInt(deltecontect[1]),deltecontect[2]);		
												 }else if(deltecontect.length ==2){

														chatobj.DeletepardicularChats(Integer.parseInt(deltecontect[1]));			
												}else if(deltecontect.length ==1&& deltecontect[0].equals("chats")){
													chatobj.DeleteAllChats();
												}

										}

										

						}else if(splitbyspace[0].equals("put")){
									System.out.println(splitbyspace[1]);
									String[] putcontectid=splitbyspace[1].split("/");
									if(putcontectid.length ==2 && putcontectid[0].equals("contacts") ){
													Scanner input = new Scanner(System.in);
													System.out.print("Enter new name = ");
													String newname=input.next();
													
													System.out.print("Enter the Number you want: ");
													long num = input.nextLong();
													contactobj.ChanchingContact(Integer.parseInt(putcontectid[1]),newname,num);	

																
									}else{
											System.out.println("Pleace enter the chanching contact id......");		
									}

						}else{
							System.out.println("Rong url........");
						}

		}

	public static void main(String[] args) {
		boolean flag=true;
				while(flag!=false){

						Scanner input=new Scanner(System.in);
						System.out.print("Enter Your URL Here=");
						String url=input.nextLine();
					
						if(url.equals("end")){
								flag=false;	
						}
						else{
							ProcessComment(url);
						}

				}		
	}
}
