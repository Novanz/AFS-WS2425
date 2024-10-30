public class WortImpl implements Wort{
    private String content;

    public WortImpl(String s) {
        this.content = s;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        WortImpl wort = (WortImpl) obj;
        return content.equals(wort.content);
    }

    @Override
    public char position(int k) {
        return content.charAt(k-1);
    }

    @Override
    public int laenge() {
        return content.length();
    }

    @Override
    public Wort concat(Wort w) {
        return new WortImpl(this.content + ((WortImpl) w).content);
    }

    @Override
    public int anzahl(char c) {
        if (this.content.isEmpty()) return 0;
        int result = 0;
        for (int i = 0; i < content.length(); i++) {
            if (content.charAt(i) == c) result++;
        }
        return result;
    }

    @Override
    public Wort tausche(char c1, char c2) {
        if (this.content.isEmpty()) return null;
        return new WortImpl(content.replace(c1,c2));
    }

    @Override
    public int istTeilwortVon(Wort w) {
        return this.content.indexOf(((WortImpl)w).content) + 1; // see indexOf() return value
    }

    @Override
    public Wort teilwort(int start, int laenge) {
        if (this.content.isEmpty())
            return null;
        return new WortImpl(this.content.substring(start - 1,start + laenge - 1)); // see page 24
    }

    @Override
    public Wort ersetze(Wort w1, Wort w2) {
        String oldWord = ((WortImpl)w1).content;
        String newWord = ((WortImpl)w2).content;
        return new WortImpl(this.content.replace(oldWord, newWord));
    }
}
