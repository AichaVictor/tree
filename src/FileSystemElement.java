package tree.src;



abstract class FileSystemElement {

    protected String elementName;

    public FileSystemElement(String elementName) {

        this.elementName = elementName;
    }

    public abstract void display(int indent, String code);


    
}