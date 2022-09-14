import com.tw.step8.shapes.Rectangle;
import com.tw.step8.shapes.Square;

public class Main {
  public static void main(String[] args) {

    Rectangle rectangle = new Rectangle(10, 20);
    System.out.println(rectangle.area());
    System.out.println(rectangle.perimeter());

    Square square = new Square(10);
  }
}