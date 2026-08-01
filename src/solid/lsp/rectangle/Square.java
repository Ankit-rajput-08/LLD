package solid.lsp.rectangle;

public class Square implements Shap{
    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return  side * side;
    }
}
