package tree.src;


import java.util.ArrayList;

public class Directory extends FileSystemElement {


    private ArrayList<FileSystemElement> children;


    public Directory(String elementName) {

        super(elementName);

        children = new ArrayList<FileSystemElement>();
    }


    public int getChildCount() {

        return children.size();
    }


    



    public  void display(int indent, String code){


        StringBuilder builder = new StringBuilder();


        int lastChildIndex = children.size() - 1;


        for (int i = 0; i < indent + 1; i++) {

            builder.append(" "); // Ajoute des espaces pour l'indentation
            

        }

        // System.out.println(builder.toString() + "\u2502");


        if (indent == 0)

            System.out.println(builder.toString() + "   " + code  + colorText(this.elementName));
        else 
            System.out.println(builder.toString() + code + "\u2500\u2500 " + colorText(this.elementName));



        for (int i = 0; i < lastChildIndex; i++) {

            FileSystemElement element = children.get(i);

            if (element instanceof Directory) {
   
            } 
            element.display(indent + 4, "\u251C"); // Incrémente l'indentation pour les sous-répertoires

        }
        if (lastChildIndex >= 0) {

            FileSystemElement lastChild = children.get(lastChildIndex);

            lastChild.display(indent + 4, "\u2514");
        }
       
    }

  

    

    public void add(FileSystemElement elementName) {
        children.add(elementName);
    }



    public String colorText(String text){

        String ANSI_RESET = "\u001B[0m";
   
        return "\u001B[31m" + text + ANSI_RESET;

    }

    
}
