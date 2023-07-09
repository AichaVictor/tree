package tree.src;

import java.io.File;


public class TestTree {



    public static void main(String[] args) {


        if(args.length != 1){

            System.out.println("pas d'arguments");

        }else {

            try {

                Directory tree = makeTree(args[0]);
                
                // tree.display(0,"");
                tree.display(0, "");

                
            } catch (Exception e) {

                System.out.println(e.getMessage());
            }
        }

    }
    




    public static Directory makeTree(String chemin) {

        File racine = new File(chemin);

        if (!racine.exists() || !racine.isDirectory()) {

            throw new IllegalArgumentException("Le dossier spécifié n'existe pas ou n'est pas un dossier valide.");
        }

        return makeDirectory(racine);
    }





    private static Directory makeDirectory(File dossier) {

        Directory directory = new Directory(dossier.getName());

        File[] composants = dossier.listFiles();


        if (composants != null) {

            for (File composant : composants) {

                if (composant.isDirectory()) {

                    

                    Directory newDirectory = makeDirectory(composant);

                    directory.add(newDirectory);

                } else {

                    if(!composant.isHidden()){

                        Files file = new Files(composant.getName());

                        directory.add(file);
                    }
                }
            }
        }

        return directory;
    }

    
}
