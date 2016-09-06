# scratchcompiler
this project is a tool to compile java source code into a runnable scratch project. ( pre-alpha! )

to build and run it, 
download the sources and unzip it on a folder
open this folder as a project on eclipse
configure the buildpath of the two .jar on lib folder
and press RUN

the folder called 'javacode' is where you put the scratch source
the folder called project, please don't change anything
and will be created a file called genereate.sb2, wich is you project compiled from 
javacode/the-java-files-that-you-put-here.any-extension

# How to write a scratch project in java

* any class will be a actor ( the class name is the actor name)
* any method will be a custom block ( with the name and parameters that you put)
* any code inside the methods will be compiled using the correspondents blocks

<
	class actor
	{
		public void power(int base,int exp)
		{
			int power_return = base;
			for(int i=1;i<exp;i++)
			{
				power_return *= base;
			}
		}
		
		public void test()
		{
			int result = power(random(1,10),random(2,5));
			waitSeconds(1);
		}
	}
>
