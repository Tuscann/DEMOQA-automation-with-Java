package demoqa.api.models;

public record Book(
        String isbn,
        String title,
        String subTitle,
        String author,
        String publish_date,
        String publisher,
        String pages,
        String description,
        String website
) {
}