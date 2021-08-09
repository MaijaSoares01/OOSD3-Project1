package assignment;
//Student Name: Maija Soares
//Student Number: C19478224
//Module: OOSD3
//Assignment Date: 16/02/21
public class Assignment1 {
	public static void main(String[] args) {
		Repository repository = new Repository();//create instance repository or Class Repository 
		Counter counterThread = new Counter(repository);//Thread counterThread connected to class Counter    
		Publisher publisherThread = new Publisher(repository);//Thread publisherThread connected to class Publisher
		//we are able to use the repository variable because of'(repository)'
		for (int j = 0; j < 21; j++) {//store and print out numbers 0-20
		counterThread.run();//runs class Counter, method run and its contents
		publisherThread.run();//runs class Publisher, method run and its contents 
		}
    }
}   
    
class Repository {//Repository Class that holds the number
	int repStorageNum;//int created to hold number value
	public Repository() { 
		this.repStorageNum = 0;
	}
	public int getNumber() {//returns number 
		return this.repStorageNum;
	}
	public void SetNumber(int storage) {//set or store number
		this.repStorageNum = storage;
	}
}
    
class Counter implements Runnable{//Counter Class that gets and updates the number
	int number = 0;
	Repository rep = null;//in order to access methods from class Repository (store and change number)
	@Override
	public synchronized void run() {//method runs when thread is called
		//System.out.println("Counter Thread running...");//comment out to show this thread does run and store and add 1 to number
		rep.SetNumber(number);//store number
		number++;//add 1 to number, which will then be stored again later...
	}
	public Counter(Repository repository) {//repository variable can be used to call methods from Repository class...
		//rep. is used to call a method from Repository class
		this.rep = repository;
	}
}   
     
class Publisher implements Runnable{//Publisher Class that gets and prints the number
	Repository rep = null;//in order to access methods from class Repository (print out number)
	@Override
	public synchronized void run() {//method runs when thread is called
		//System.out.println("Publisher Thread running...");//comment out to show this thread does run and print number
		int printNumber = rep.getNumber();//set printNumber to equal number in repository
		System.out.println("Number: " + printNumber);//print out this number
	}
	public Publisher(Repository repository) {//repository variable can be used to call methods from Repository class...
		//rep. is used to call a method from Repository class
		this.rep = repository;
	}
}
