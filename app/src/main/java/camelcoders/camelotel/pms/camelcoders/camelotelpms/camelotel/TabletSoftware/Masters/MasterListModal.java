package camelcoders.camelotel.pms.camelcoders.camelotelpms.camelotel.TabletSoftware.Masters;

public class MasterListModal {
    private String rank;
    private String movieName;
    private String year;
    private String budgetInMillions;

    public MasterListModal(String rank, String movieName, String year, String budgetInMillions) {
        this.rank = rank;
        this.movieName = movieName;
        this.year = year;
        this.budgetInMillions = budgetInMillions;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBudgetInMillions() {
        return budgetInMillions;
    }

    public void setBudgetInMillions(String budgetInMillions) {
        this.budgetInMillions = budgetInMillions;
    }
}