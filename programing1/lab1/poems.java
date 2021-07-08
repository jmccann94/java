
public class poems {
  
  
  public static void main(String[] args) { 
  
    System.out.println("Lab 1 Written by Justin McCann \n");
    littlelamb();
    oldman();
  }
   
    
    //Method will call the first verse of mary  (inc)
    public static void littlelamb(){
      System.out.println("Mary had A Little Lamb\n");
      maryhad();
      mone();
      maryhad();
      mtwo();
    }
    //method for line 2
    public static void mone(){
      System.out.println("Little lamb, little lamb");
    }
    //method for line 4
    public static void mtwo(){
      System.out.println("Its fleece was white as snow\n");
    }
    //method for line 1 and 4\3
    public static void maryhad(){
      System.out.println("Mary had a little lamb,");
    }
    
    //
    //method for this old man
    public static void oldman(){
      oone();
      otwo();
      othree();
    }
    
    //method for old verse 1
    public static void oone(){
      manplayed(); 
      System.out.println("one");
      knick();
      System.out.println("thumb");
      home();
    }
    //method for old verse 2
    public static void otwo(){ 
      manplayed();
      System.out.println("two");
      knick();
      System.out.println("shoe");
      home();
    }
    //method for old verse 3
      public static void othree(){
      manplayed();
      System.out.println("three");
      knick();
      System.out.println("knee");
      home();
    }
    //method for played line
    public static void manplayed(){
      System.out.print("This old man, he played ");
    }
    
    //method for knickknack
    public static void knick(){
      System.out.print("He played knick-knack on my ");
    }
    
    //method for rolling home
    public static void home (){
      System.out.println("With a knick-knack patty-whack, give the dog a bone");
      System.out.println("This old man came rolling home\n");
    }

  }
