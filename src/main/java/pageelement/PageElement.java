package pageelement;


public abstract class PageElement {

    protected final String elemId;


    protected PageElement(String elemId, String idType) {
        this.elemId = elemId;
    }

    public String getElemId() {
        return elemId;
    }

}