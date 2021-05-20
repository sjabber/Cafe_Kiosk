package page;

public class PageData {

    private final PageType nextPageType;
    private final PageType previousPageType;

    private PageData(Builder builder) {
        this.nextPageType = builder.nextPageType;
        this.previousPageType = builder.previousPageType;
    }

    PageType getNextPageType() {
        return nextPageType;
    }


    public static class Builder {
        public Builder() {
        }

        private PageType nextPageType = PageType.EMPTY_PAGE;
        private PageType previousPageType = PageType.EMPTY_PAGE;

        public Builder nextPageType(PageType pageType) {
            this.nextPageType = pageType;
            return this;
        }

        public Builder previousPageType(PageType pageType) {
            this.previousPageType = pageType;
            return this;
        }

        public PageData build() {
            return new PageData(this);
        }
    }
}
