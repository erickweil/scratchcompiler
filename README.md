# scratchcompiler
this project is a tool to compile java source code into a runnable scratch project. ( pre-alpha! ) <br>

# Download ( Do that if you just want to make a project)
* always will be the most updated link here: https://github.com/erickweil/scratchcompiler/releases
* to install is simple, just unzip the archive and it's 'installed'
	it requires
	* Java 8 jre or jdk installed
	* A good text editor ( https://notepad-plus-plus.org/ )
	* Some java coding practice ( but you can learn it by seeing the example and changing a bit )
	after unziping you will see: <br>
	folder javacode <-- you put your code here <br>
	folder project <-- Don't touch <br>
	archive generated.sb2 <-- your project! <br>
	archive scratchcompiler.jar <-- to compile the code at javacode/anyfile.anyextension<br>
	
	the folder project you ignore, and don't mess with it<br>
	the folder javacode is where you put your text files with the code<br>
	are a example there already, so is not that dificult once you keep the concept<br>
	
	when you click the scratchcompiler.jar will compile anything you put in javacode folder<br>
	into the generated.sb2, wich you open with the offline editor, or in the online editor you choose<br>
	to open from file...<br>

# Build from sources ( Advanced Java programmer )
* download the sources and unzip it on a folder 
* open this folder as a project on eclipse 
* configure the buildpath of the two .jar on lib folder 
* and press RUN ( the Main.java)

obs: the Update.java file will compile the grammar, so if you do that, consider that any change in the grammar
without adapting the program will make it crash!

the folder called 'javacode' is where you put the scratch source <br>
the folder called project, please don't change anything <br>
after you run will be created a file called generated.sb2, wich is you project compiled from <br>
javacode/the-java-files-that-you-put-here.any-extension <br>

# How to write a scratch project in java

* any class will be a actor ( the class name is the actor name)
* any method will be a custom block ( with the name and parameters that you put)
* any code inside the methods will be compiled using the correspondent blocks

ALERT

* be careful with variables, they are GLOBAL, scope? what is that?
* method parameters can't be changed
* recursion may will not work as expected in java, as said above variables are global

```java
class actor // the actor will be named 'actor' on scratch
{
	public int power(int base,int exp) // a custom block called power with two arguments
	{
		int result = base; // you can't modify parameters
		for(int k=1;k<exp;k++) // counter ( k instead of i because all variables are global )
		{
			result *= base; // this in fact is power_return = power_return * base
		}
		return result; // this is a shortcut to assign to a variable named <method_name>_return and then stop that script
	}

	public void test() // a custom block called test with no arguments
	{	
		int[] powers_of_two = new int[]{0,0,0,0,0,0,0,0,0,0};
		for(int i=1;i<=10;i++) // a for loop is a repeat until( not condition ) with the counter var
		{
			powers_of_two[i] = power(2,i);
		}
		waitSeconds(1); // you can call scratch blocks using a method call ( it is not complete )
	}
}
```


