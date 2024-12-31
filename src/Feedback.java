public class Feedback {
    private String userName;
    private String pizzaName;
    private int rating;
    private String comments;

    public Feedback(String userName, String pizzaName, int rating, String comments) {
        this.userName = userName;
        this.pizzaName = pizzaName;
        this.rating = rating;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "userName='" + userName + '\'' +
                ", pizzaName='" + pizzaName + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
