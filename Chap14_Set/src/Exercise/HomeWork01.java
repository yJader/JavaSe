package Exercise;

import java.util.ArrayList;

public class HomeWork01 {
    public static void main(String[] args) {
        ArrayList<New> News = new ArrayList<New>();

        News.add(new New("新冠确诊病例超千万，数百万印度教信徒赴恒河“圣浴”引民众担忧"));
        News.add(new New("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生"));

        for (int i = News.size()-1; i >= 0; i--) {
            New n = (New)News.get(i);
            StringBuilder sb = new StringBuilder(n.getTitle());
            sb.replace(15, sb.length(), "...");
            n.setTitle(sb.toString());
            System.out.println(n);
        }
    }
}

class New{
    private String title;
    private String content;

    public New(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public New(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "New{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}