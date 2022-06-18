package model;

public enum Ship {
    BLUE("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerShip3_blue.png",
            "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerLife3_blue.png"),
    GREEN("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerShip3_green.png",
            "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerLife3_green.png"),
    ORANGE("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerShip3_orange.png",
            "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerLife3_orange.png"),
    RED("C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerShip3_red.png",
            "C:\\Users\\petko.lyutskanov\\Desktop\\Student\\IdeaProjects\\GalaxyDodger\\GalaxyDodger\\src\\main\\java\\view\\resources\\shipchooser\\playerLife3_red.png");

    private String urlShip;
    private String urlLife;

    private Ship(String urlShip, String urlLife) {
        this.urlShip = urlShip;
        this.urlLife = urlLife;
    }

    public String getUrl() {
        return this.urlShip;
    }

    public String getUrlLife() {
        return urlLife;
    }
}
