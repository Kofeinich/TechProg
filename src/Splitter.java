public final class Splitter {
    private String line;

    public Splitter(String ourLine){
        this.line = ourLine;
    }

    public String[] parse(){
        line = line.replaceAll("’","");
        var strMas = line.split(";");
        return strMas;
    }
}
