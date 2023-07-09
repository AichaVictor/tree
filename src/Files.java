package tree.src;

class Files extends FileSystemElement {

    public Files(String elementName) {

        super(elementName);
    }



    public void display(int indent, String code) {

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < indent  + 1; i++) {
            builder.append(" "); // Ajoute des espaces pour l'indentation
        }
        // System.out.print("\u2502");
        System.out.println( builder.toString() + code + "\u2500\u2500 " + this.elementName);

    }

    


}
