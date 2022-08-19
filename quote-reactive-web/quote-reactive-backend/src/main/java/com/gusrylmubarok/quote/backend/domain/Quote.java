package com.gusrylmubarok.quote.backend.domain;

import java.util.Objects;

public final class Quote {
    private String id;
    private String book;
    private String content;

    public Quote() {
    }

    public Quote(String id, String book, String content) {
        this.id = id;
        this.book = book;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "id='" + id + '\'' +
                ", book='" + book + '\'' +
                ", content='" + content + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Quote quote = (Quote) o;
        if (!Objects.equals(id, quote.id)) return false;
        if (!Objects.equals(book, quote.book)) return false;

        return Objects.equals(content, quote.content);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }
}
