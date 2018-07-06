package pds;
import java.io.*;
import java.util.*;
public class Driver {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ch,sch,cch;
		int pId=0,oId=0;
		ArrayList<Pizza> pizza= new ArrayList<Pizza>();
		ArrayList<Order> order= new ArrayList<Order>();
		Order o;
		Pizza p;
		do {
			System.out.println("Welcome to Pizza King");
			System.out.println("\n\n Press - \n 1. Shopkeeper\n2.Customer\n 0. Exit\n");
			ch= Integer.parseInt(br.readLine());
			switch(ch) {
			case 1:
				do {
					System.out.println("\nWelcome\n\n 1. Add Pizza \n2. View Order \n3. Exit\n");
					sch= Integer.parseInt(br.readLine());
					if(sch==1) {
						p=new Pizza();
						System.out.println("enter pizza name : ");
						p.setpName(br.readLine());
						System.out.println("enter pizza price : ");
						p.setpPrice(Integer.parseInt(br.readLine()));
						System.out.println("enter pizza type : ");
						p.setpType(br.readLine());
						System.out.println("enter pizza size : ");
						p.setpSize(br.readLine());
						System.out.println("enter pizza base : ");
						p.setpBase(br.readLine());
						p.setpId(pId);
						pId++;
						pizza.add(p);
						System.out.println("\n\n Pizza added successfully to menu\n\n Your current menu is \n\n Pizza Id\tPizza \t\tPrice\t\tType\t\tSize\t\tBase\n");
						for(Pizza pi:pizza) {
							System.out.println(pi.pId+"\t\t"+pi.pName+"\t\t"+pi.pPrice+"\t\t"+pi.pType+"\t\t"+pi.pSize+"\t\t"+pi.pBase+"\n");
						}
					}
					if(sch==2) {
						System.out.println("the orders are :\n");
						System.out.println("Order Id\tPizza Id\tPizza name\tPizza Type\tPizza size\tPizza Base\tTotal Amount\n");
						
						for(Order or:order) {
							System.out.println(or.getoId()+"\t\t"+or.getpId()+"\t\t"+or.getpName()+"\t\t"+or.getpType()+"\t\t"+or.getpSize()+"\t\t"+or.getpBase()+"\t\t"+or.getoAmount()+"\n");
						
						}
					}
				}while(sch!=3);
				break;
			case 2:
				
				do {
					int ach=1;
					int nch;
					int k=0;
					String nId="",nName="",nType="",nSize="",nBase="";
					double nPrice=0.0;
					System.out.println("\nWelcome to Pizza King\n\n");
					System.out.println("1. Place an order\n2.View Order\n3.Cancel Order\n4.Order Received\n 5. Exit\n\n Please select an appropriate option:\n");
					cch=Integer.parseInt(br.readLine());
					if(cch==1) {
						o=new Order();
						p=new Pizza();
						while(ach==1) {
							
							System.out.println("our menu is :\n Pizza Id\t\tPizza \t\tPrice\t\tType\t\tSize\t\tBase\n\n");
							for(Pizza pi:pizza) {
								System.out.println(pi.pId+"\t\t"+pi.pName+"\t\t"+pi.pPrice+"\t\t"+pi.pType+"\t\t"+pi.pSize+"\t\t"+pi.pBase+"\n");
							}
							System.out.println("\n Please select the pizza id to order:\n");
							nch=Integer.parseInt(br.readLine());
							if(nch>=pId) {
								System.out.println("wrong choice\n");
							}
							else {
								
								for(Pizza pi:pizza) {
									if(pi.pId==nch) {
										p=pi;
										break;
									}
									
								}
								
								if(k==0) {
									nName=p.getpName();
									nId=Integer.toString(p.getpId());
									nType=p.getpType();
									
									System.out.println("what size do you want -> regular (r), medium(m),large(l):\n");
									nSize=br.readLine();
									System.out.println("What base do you want -> regular (r), pan(p)\n");
									nBase=br.readLine();
									if(nSize.equals("r")) {
										nPrice=p.getpPrice();
									}
									else if(nSize.equals("m")) {
										nPrice=p.getpPrice()+100;
									}
									else if(nSize.equals("l")){
										nPrice=p.getpPrice()+200;
									}
									if(nBase.equals("p")) {
										nPrice+=100;
									}
									
									
								}
								else {
									String s,b;
									nName+=","+p.getpName();
									nId+=","+p.getpId();
									nType+=","+p.getpType();
									System.out.println("what size do you want -> regular (r), medium(m),large(l):\n");
									s=br.readLine();
									nSize+=","+s;
									System.out.println("What base do you want -> regular (r), pan(p)\n");
									b=br.readLine();
									nBase+=","+b;
									if(s.equals("r")) {
										nPrice+=p.getpPrice();
									}
									else if(s.equals("m")) {
										nPrice+=p.getpPrice()+100;
									}
									else {
										nPrice+=p.getpPrice()+200;
									}
									if(b.equals("p")) {
										nPrice+=100;
									}
									
								}
								
								
								
							}
							k++;
							System.out.println("do you want to add more pizza\n1. Yes\n2.No\n");
							ach=Integer.parseInt(br.readLine());
						}
						o.setoId(oId);
						o.setoAmount(nPrice);
						o.setpBase(nBase);
						o.setpId(nId);
						o.setpName(nName);
						o.setpSize(nSize);
						o.setpType(nType);
						o.setpDeliver("Not delivered");
						order.add(o);
						System.out.println("Your order is :\n");
						System.out.println("Order Id\tPizza Id\tPizza name\tPizza Type\tPizza size\tPizza Base\tTotal Amount\tStatus\n");
						System.out.println(o.getoId()+"\t\t"+o.getpId()+"\t\t"+o.getpName()+"\t\t"+o.getpType()+"\t\t"+o.getpSize()+"\t\t"+o.getpBase()+"\t\t"+o.getoAmount()+"\t"+o.getpDeliver()+"\n");
						
						oId++;
					}
					else if(cch==2) {
						Order or;
						int id,flag=0;
						System.out.println("Please provide your order id:\n");
						id=Integer.parseInt(br.readLine());
						for(Order ord:order) {
							if(ord.getoId()==id) {
								or=ord;
								flag=1;
								System.out.println("Your order is :\n");
								System.out.println("Order Id\tPizza Id\tPizza name\tPizza Type\tPizza size\tPizza Base\tTotal Amount\tStatus\n");
								System.out.println(or.getoId()+"\t\t"+or.getpId()+"\t\t"+or.getpName()+"\t\t"+or.getpType()+"\t\t"+or.getpSize()+"\t\t"+or.getpBase()+"\t\t"+or.getoAmount()+"t"+or.getpDeliver()+"\n");
							
								break;
							}
						}
						if(flag==0) {
							System.out.println("wrong order id\n");
						}
						
					}
					else if(cch==3) {
						int id,flag=0;
						Order or;
						System.out.println("Please provide your order id:\n");
						id=Integer.parseInt(br.readLine());
						for(Order ord:order) {
							if(ord.getoId()==id) {
								or=ord;
								flag=1;
								order.remove(or);
								System.out.println("your order has been deleted\n\n");
								break;
							}
						}
						if(flag==0) {
							System.out.println("wrong order id\n");
						}
					}
					else if(cch==4) {
						int id,flag=0;
						Order or;
						System.out.println("Please provide your order id:\n");
						id=Integer.parseInt(br.readLine());
						for(Order ord:order) {
							if(ord.getoId()==id) {
								or=ord;
								flag=1;
								or.setpDeliver("delivered");;
								System.out.println("your order has been delivered.Enjoy your pizza\n\n");
								break;
							}
						}
						if(flag==0) {
							System.out.println("wrong order id\n");
						}
					}
					
				}while(cch!=5);
				break;
			}
		}while(ch!=0);
		
	}
}
