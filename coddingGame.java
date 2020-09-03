class A {

/**
* Executes the service with the given connection.
 */
 void a(Service s, Connection c) {
// update this code
 s.setConnection(c);
 try {
 s.execute();
 } catch(Exception e) {
 c.rollback();
 } finally {
 c.commit();
}

 c.close();
 }

 }

 interface Service {
 void execute() throws Exception;
 void setConnection(Connection c);
 }

 interface Connection {
 void commit();
 void rollback();
 void close();
 }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
abstract  class Animal {
	String name;
	
	public Animal(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	

}


public class Cat extends Animal {   }
//******************************************************************

public class Dog extends Animal{
	public Dog (String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}


public class Catextends Animal{
	public Cat(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
}

///******************************************************************************

public class Resultat {

	public static void main(String[] args) {
Animal cat=new Cat("Sammy");
Animal dog=new Dog("Smokey");
System.out.println(cat.getName());
System.out.println(dog.getName());
	}

}





class Solution {

	static int closestToZero(int[] numbers) {
		if (numbers.length == 0) return 0;

		   int curr = 0;
            int near = numbers[0];
 // find the element nearest to zero
   for ( int i=0; i <= numbers.length; i++ ){
    curr = numbers[i] * numbers[i];
     if ( curr <= (near * near) ) {
        near = numbers[i];
 }
 } 
		return near;
	}
}



static double approx(double[][] rands) 
{
	double x,y;
	int cpt=0;
	double pi;
	
	for(int i=0;i<rands.length;i++)
	{ 
	
		x=(double)Math.random();
		y=(double)Math.random();
		if(x <=1 && y<=1)
		{
			rands[i][0]=x;
			rands[i][1]=y;
		}
	if(x*x+y+y<=1)
	{
		cpt++;
	}
}
	pi=cpt*4/(double)rands.length;

	return pi;
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static void itererRepertoire(String repertoire, int j) {

 File dir = new File(repertoire);
 System.out.println(repertoire) ;
 System.out.println("j : " + j) ;
 if(dir.isDirectory()){
 String s[] = dir.list();
 for (int i=0; i<s.length; i++){

 File dirTemp = new File(repertoire + s[i] + "\\" );

 if(dirTemp.isDirectory() && j > 0){
itererRepertoire(repertoire + s[i] + "\\", j-1);
 }

 if(!dirTemp.isDirectory()){
 System.out.println("fichier : " + s[i]);
 }
 }
 }
 }

 class Solution {
/** Counts the number of pairs for n players. */
static int count(int n) {
 return (n*(n-1))/2;
 }
 }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class HelloWorld{
 public static String thirdConcat(List<String>list) {
 StringBuilder resultBuilder = new StringBuilder();
 for (String value : list) {
 resultBuilder.append(value);
 }
 return resultBuilder.toString();
 }
public static void main(String []args){
String s=thirdConcat(lst);
 System.out.println(""+s);
 }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Counter {

    private int count = 0;

    public int getCount() {
        return count ;
    }

    public synchronized void increment() {
        ++count;
    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class OtherClass
{

  public  void OtherClass(String input)
  {
   String[] parts = input.split(" ");
  
    for(int i=0;i<parts.length;i++ )
    {
      System.out.print(parts[i]+"\n");
      }
  }
  
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public static boolean isParenthesisMatch(String str) {
	    Stack<Character> stack = new Stack<Character>();

	    char c;
	    for(int i=0; i < str.length(); i++) {
	        c = str.charAt(i);

	        if(c == '{')
	            return false;

	        if(c == '(')
	            stack.push(c);

	        if(c == '{') {
	            stack.push(c);
	            if(c == '}')
	                if(stack.empty())
	                    return false;
	                else if(stack.peek() == '{')
	                    stack.pop();
	        }
	        else if(c == ')')
	            if(stack.empty())
	                return false;
	            else if(stack.peek() == '(')
	                    stack.pop();
	                else
	                    return false;
	        }
	        return stack.empty();
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class TestCodingame {
	//Arbre des noueuds
	public static void main(String[] args)  {
          Integer[] fromIds = { 1, 2, 5, 4, 3,1};
          Integer[] toIds =   { 2, 5, 4, 3, 1,2};
          System.out.println("saisir le noeud de départ");
          int startNodeId = 5;
          System.out.println("startNodeId :  "+startNodeId);
          int endPointId = findNetworkEndpoint(startNodeId, fromIds, toIds);
          System.out.println("endPointId :  "+endPointId);
      }
	/****************************************************************************************************/
	/*****************************************************************************************************/
    public static int findNetworkEndpoint(int startNodeId, Integer[] fromIds, Integer[] toIds)   {
        int fromIndex = 0; 
        List<Integer>inputs=new ArrayList<Integer>();
        List<Integer> froms = Arrays.asList(fromIds);
        List<Integer> toId = Arrays.asList(toIds);
        boolean continueloops = true;
        if(froms.indexOf(startNodeId)==-1 && toId.indexOf(startNodeId)==-1) {
        	return 0;
        }
        while (continueloops){
            if (inputs.contains(startNodeId) || fromIndex == -1)
            {
                continueloops = false;
            }
            else
            {
                inputs.add(startNodeId);
                fromIndex = froms.indexOf(startNodeId);
                if (fromIndex != -1)
                {
                	startNodeId = toIds[fromIndex];
                }       
            }
        }
        return startNodeId;
    }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class increment {
 public static int currentCount=0;

public static synchronized void  increment () {
        //do something...
       currentCount++;
      return currentCount;
    }

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////

   
public static boolean istPalindrom(char[] word){
    int i1 = 0;
    int i2 = word.length - 1;
    while (i2 > i1) {
        if (word[i1] != word[i2]) {
            return false;
        }
        ++i1;
        --i2;
    }
    return true;
}

//********************************************************************************

public static boolean isPalindrome(String str) {
    return str.equals(new StringBuilder(str).reverse().toString());
}

//*********************************************************




public static boolean isBalanced(String s) {
    Map<Character, Character> openClosePair = new HashMap<Character, Character>();
    openClosePair.put('(', ')');
    openClosePair.put('{', '}');
    openClosePair.put('[', ']'); 

    Stack<Character> stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {

        if (openClosePair.containsKey(s.charAt(i))) {
            stack.push(s.charAt(i));

        } else if ( openClosePair.containsValue(s.charAt(i))) {
            if (stack.isEmpty())
                return false;
            if (openClosePair.get(stack.pop()) != s.charAt(i))
                return false;
        }

        // ignore all other characters

    }
    return stack.isEmpty();
}




//*************************************************************************************************************
public static boolean isParenthesisMatch(String str) {
    if (str.charAt(0) == '{')
        return false;

    Stack<Character> stack = new Stack<Character>();

    char c;
    for(int i=0; i < str.length(); i++) {
        c = str.charAt(i);

        if(c == '(')
            stack.push(c);
        else if(c == '{')
            stack.push(c);
        else if(c == ')')
            if(stack.empty())
                return false;
            else if(stack.peek() == '(')
                stack.pop();
            else
                return false;
        else if(c == '}')
            if(stack.empty())
                return false;
            else if(stack.peek() == '{')
                stack.pop();
            else
                return false;
    }
    return stack.empty();
}
publicbooleanisPrime(intn) {
		
		booleanisPrime = true;
		
		if (n< 0 || n== 1) {
			
			isPrime = false;
			
		}
		elseif (n != 0 &&n != 1) {
			
			for (inti = 2; i<= n/2; i++) { 
				if (n != i&&n % i == 0) {
					isPrime = false;
					break;
					}
				}
			}
		return isPrime;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public class HelloWorld
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {
    OtherClass myObject = new OtherClass();
myObject.OtherClass("Hello  World!");
  }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class OtherClass
{

  public  void OtherClass(String input)
  {
   String[] parts = input.split(" ");
  
    for(int i=0;i<parts.length;i++ )
    {
      System.out.print(parts[i]+"\n");
      }
  }
  
}
Public static int getPositionAt(intn)
    {
switch (n%6)
        {
case 0: return 0;
case 1: return 1;
case 2: return -1;
case 3: return -4;
case 4: return -5;
case 5: return -3;
        }
return 0;
    }


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class locateUniverseFormula {

    /**
     * Locates the universe-formula​​​​​​​‌‌‌​​​​​​‌‌‌​​​‌​‌​​​​‌​ file.
     */
    static String locateUniverseFormula() {
	String path = "/tmp/documents/";
	String fName = "universe-formula";
	File file = find(path, fName);
	return file.getAbsolutePath();
    }

    public static File find(String path, String fName) {
	File f = new File(path);
	if (fName.equalsIgnoreCase(f.getName()))
	    return f;
	if (f.isDirectory()) {
	    for (String aChild : f.list()) {
		File ff = find(path + File.separator + aChild, fName);
		if (ff != null)
		    return ff;
	    }
	}
	return null;
    }

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



	staticintfindLargest(int[] numbers){
		
		int max = numbers[0];
		for (int i : numbers) {
			if(i>max)
				max =i;
		}
		returnmax;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class Node {
 // keep these fields
 Node left, right;
 int value;
 public Node find(int v){
 Node n = this;
 while (n != null)
 {
 if (v > n.value)
 n = n.right;
Recherche nœud dans une arbre
 else if (v < n.value)
 n = n.left;
 else // v == n.value
 return n;
 }
 return null;
 }
}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
Nombre Permier

publicbooleanisPrime(intn) {
		
		booleanisPrime = true;
		
		if (n< 0 || n== 1) {
			
			isPrime = false;
			
		}
		elseif (n != 0 &&n != 1) {
			
			for (inti = 2; i<= n/2; i++) { 
				if (n != i&&n % i == 0) {
					isPrime = false;
					break;
					}
				}
			}
		returnisPrime;
		}

Nombre Permier
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public boolean isPrime(int n) {
		
		boolean isPrime = true;
		
		if (n< 0 || n== 1) {
			
			isPrime = false;
			
		}
		elseif (n != 0 &&n != 1) {
			
			for (inti = 2; i<= n/2; i++) { 
				if (n != i&& n % i == 0) {
					isPrime = false;
					break;
					}
				}
			}
		return isPrime;
		}

 // Java code below


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 class Solution {
public static String reshape(int n, String str) {

 str = str.replaceAll("\\s","");
 String [] res = str.split("(?<=\\G.{"+n+"})");
 return String.join("\\n",res);
 }

 }


/****/
 public static String reshape(int n, String str) {
        //replace each space with empty string
        str = str.replace(" ", "");
        
        //insert a '\n' character each n characters
        String res = "";
        for (int i = 0; i < str.length(); i++)
        {
            if (i%n == 0 && i != 0)
                res = res +'\n' +str.charAt(i);
            else
                res += str.charAt(i);
        }
        
        return res;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public class Scanchar {

    public static void main(String[] args) {

    System.out.println(AsciiArt1.printChar('A'));	
    }

    /**
     * Return the char that is represented by s
     */
    public static char scanChar(String s) {
	
	for (char c = 'A'; c <= 'Z'; c++) {

	    if (AsciiArt1.printChar(c) == s) {
		
		return c;
	    }
	}

	return '?';

    }

}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
class AsciiArt1 {
    public static String printChar(char s) {
	return "A";
    }
}
public class SommeClass {
	public int somme(int s) {
		int som = s;
		while (s != 0 && s < 20000000) {
			som = som + s % 10;
			s = s / 10;
		}
		return som;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

publicclass Stack {

	//keep these two fields as they are
	private Object[] elements;
	private int size =0;
	
	public Stack(int  initialCapacity){
		elements = new Object[initialCapacity];
	}
	
	publicvoid push(Object object){
		ensureCapacity();
		elements[size++] = object;
	}
	
	public Object pop(){
		if(size == 0){
			thrownewEmptyStackException();
		}
		returnelements[--size];
	}


private void ensure Capacity(){
		if(elements.length == size){
			Object[] old = elements;
			elements= new Object[2* size +1];
			System.arraycopy(old, 0, elements, 0, size);
		}
	}
	
	publicstaticvoid main(String args[]){
		
		Stack stack= newStack(100);
	}
	
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

Class SreamPrinter
{

void print(Reader reader) throws IOException
{
int code =reader.read();
try
{
while(code !=-1)
	
code =reader.read();
}
}
fnaly
{
	reader.close();
}










}