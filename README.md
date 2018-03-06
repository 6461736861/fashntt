# Automation #

Automation project for site admin portal

  - Project: http://fashionette.de


## Setup Env ##


### Install brew ###

https://brew.sh/

sh
> brew -v
Homebrew 1.3.7
Homebrew/homebrew-core (git revision f35f0; last commit 2017- 11-21)


### Install cask ###

 sh
> brew tap caskroom/cask


sh
> brew cask --version
Homebrew-Cask 1.3.7
caskroom/homebrew-cask (git revision c4b0f; last commit 2017- 11-21)


### Install java ###

sh
> brew cask install java


sh
> java --version
java 9.0.1
Java(TM) SE Runtime Environment (build 9.0.1+11)
Java HotSpot(TM) 64-Bit Server VM (build 9.0.1+11, mixed mode)


### Set JAVA_HOME ###

https://www.mkyong.com/java/how-to-set-java_home- environment-variable-on-mac-os-x/


> vim ~/.bash_profile



export JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home



> echo $JAVA_HOME
/Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home


### Install intellij idea ###


> brew cask install caskroom/cask/intellij-idea-ce


### Install maven ###


> brew install maven



> mvn -v
Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T10:58:13+03:00)
Maven home: /usr/local/Cellar/maven/3.5.2/libexec Java version: 9.0.1, vendor: Oracle Corporation


### Install Chrome ###


> brew cask install google-chrome


### Install Chrome Extensions ###

- Ranorex Selocity https://www.ranorex.com/selocity/browser-extension.html

### Download chromedriver ###


> brew install chromedriver



> chromedriver
Starting ChromeDriver 2.33.506106 (8a06c39c4582fbfbab6966dbb1c38a9173bfb1a2) on port 9515
Only local connections are allowed.


### Install git ###


> brew install git



> git --version
git version 2.13.0



## Setup project ###

### Create folder ###


> mkdir ~/git
> cd ~/git


### Clone repo ###


> git clone ssh://


### Open in IDE ###

`File` > `Open...`

### Check JDK ###

Check `File` > `Project Structure...` > `Platform Settings` > `SDKs`. If empty - add your installed `jdk` here.

## Run tests ##

### IDE run in Chrome ###

Open test file `*Story.java` and just click green triangle

### Terminal run in Chrome ###


> mvn clean verify -Dwebdriver.driver=chrome



## Structure ##

### About project ###


.test.automation
├── factories
├── features
├── model
├── pages
├── steps
└── tech


- `factories` - set of methods that fill `model` with random data
- `features` - tests, here test-logic, it use `steps`
- `steps` - here business-logic, it use `pages`
- `pages` - here technical-realisation, it use locators, selenium/serenity commands
- `model` - describe entities
- `tech` - helpers, extensions and other technical stuff

### PageObjectExtension.java ###

This file contains methods to extend `Serenity`.

Here a bunch of methods that highlight (with red rectangle) controls:

- `highlight`
- `highlightFind`
- `highlightClick`
- `highlightType`

It used in pages.

## How to create new tests ##

Just add one file to each package.

For example: we write tests for `purpose`.

It need create:

- in `features` file `PurposeStory` that extends from BaseFeature. Always start from test-design. In `PurposeStory` put a set of blank test how-to create, read, update, delete (CRUD) + search `purpose`

java
public class PurposeStory extends BaseFeature {

    @Steps
    private PurposeSteps _purpose;

    @Before
    public void open_purpose_page() {
        _purpose.open_page();
    }

    @Test
    public void create_purpose() {
        // Your test here
    }
}

- in `model` file `PurposeModel` that extends from `BaseModel` Describe your set of data.

java
public class PurposeModel extends BaseModel {
    public String id;
    public String name;
    public String description;
    // etc.
}


- in `steps` file `PurposeSteps` that implements `ISteps`. `Isteps` require you to implement method `open_page()`. Create other steps for CRUD + search + accessors for make assertions.

java
public class PurposeSteps implements ISteps {

    CampaignPage campaignPage;
    PurposeListPage listPage;
    PurposeCreatePage createPage;

    @Step
    public void open_page() {
        campaignPage.open();
        campaignPage.openPurposeTab();
    }

    @Step
    public void create_new(PurposeModel purpose) {
        listPage.openCreationForm();
        createPage.fillCreationForm(purpose);
        createPage.submitCreationForm();
    }
    
    // Other steps here
}


- in `pages` a set of pages it may be `*ListPage`, `*CreatePage`, `*ImportPopup` etc. All pages extends from `PageObjectAdminPortalExtension`. Implement all page's methods using selenium/serenity commands

- in `factories` you can create file `PurposeFactory` that extends from `BaseFactory` that will help you to fill `model` with random data.

java
public class PurposeFactory extends BaseFactory {
    public static PurposeModel random() {
        PurposeModel data = new PurposeModel();
        data.name = String.format("PurposeName-%s", UUID.randomUUID());
        data.description = String.format("PurposeDescription-%s", UUID.randomUUID());
        // etc.
        return data;
    }
}


## Links ##

- `serenity` http://thucydides.info/docs/serenity-staging/#introduction
- `assertj` http://joel-costigliola.github.io/assertj/
