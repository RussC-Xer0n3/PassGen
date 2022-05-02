<style>
/* The dropdown container */
.dropdown {
  float: left;
  overflow: hidden;
}
/* Dropdown button */
.dropdown .dropbtn {
  font-size: 16px;
  border: none;
  outline: none;
  color: white;
  padding: 14px 16px;
  background-color: inherit;
  font-family: inherit; /* Important for vertical align on mobile phones */
  margin: 0; /* Important for vertical align on mobile phones */
}
/* Add a red background color to navbar links on hover */
.navbar a:hover, .dropdown:hover .dropbtn {
    background-color: aliceblue;
    color: teal;
  }
  /* Dropdown content (hidden by default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: teal;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}
/* Links inside the dropdown */
.dropdown-content a {
  float: none;
  color: aliceblue;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}
/* Add a grey background color to dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
}
/* Show the dropdown menu on hover */
.dropdown:hover .dropdown-content {
  display: block;
}
</style>
<nav class="w3-container w3-teal w3-center w3-margin-top">
    <div class="dropdown">
        <button class="dropbtn">Projects
          <i class="fa fa-caret-down"></i>
        </button>
        <div class="dropdown-content">
          <a href="https://russc-xer0n3.github.io/NetPCaC">NetPCaC</a>
          <a href="https://russc-xer0n3.github.io/LANDROVER">LANDROVER</a>
          <a href="https://russc-xer0n3.github.io/MAC">MAC Address</a>
          <a href="https://russc-xer0n3.github.io/SCRUD">SCRUD</a>
          <a href="https://russc-xer0n3.github.io/Remove">Code Syntax Removal</a>
          <a href="https://russc-xer0n3.github.io/PassGen">PassGen</a>
          <a href="https://russc-xer0n3.github.io/C_Shapes">C Programming Shap`es</a>
          <a href="https://russc-xer0n3.github.io/Shapes---python">Python Shapes and space</a>
          <a href="https://russc-xer0n3.github.io/The-old-Fusion-Repository">Fusion?</a>
          <a href="https://russc-xer0n3.github.io/The-Russian-Wedding-Rings">The Russian Wedding Rings</a>
          <a href="https://russc-xer0n3.github.io/QBit-and-GParticulates">QBit and GParticulates</a>
          <a href="https://russc-xer0n3.github.io/Thyme-old">Thyme</a>
          <a href="https://russc-xer0n3.github.io/IP-Port">IP and Ports</a>
          <a href="https://russc-xer0n3.github.io/Xer0n3">Xer0n3</a>
          <a href="https://russc-xer0n3.github.io/ScrambledEggs">ScrambledEggs</a>
          <a href="https://russc-xer0n3.github.io/Py">Python Code</a>
        </div>
    </div>
    <br>
      <a href="https://www.facebook.com/profile.php?id=100075972987666"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
      <a href="https://www.instagram.com/russellclarke821"><i class="fa fa-instagram w3-hover-opacity"></i></a>
      <a href="https://www.pinterest.co.uk/russellclarke821/"><i class="fa fa-pinterest-p w3-hover-opacity"></i></a>
      <a href="https://twitter.com/Developing821"><i class="fa fa-twitter w3-hover-opacity"></i></a>
      <a href="https://www.linkedin.com/in/russell-clarke-09a1a5238"></a><i class="fa fa-linkedin w3-hover-opacity"></i>
      <a href="https://russc-xer0n3.github.io">My CV and additionsl information</a>
    <br>
</nav>
# PassGen
## A Password Generator Android Application

### The Password Generator
The interesting component of the application was the generator a rewrite from [StackOverflow User cmpbah](https://stackoverflow.com/users/1336707/cmpbah) [and erickson](https://stackoverflow.com/users/3474/erickson) from [here](https://stackoverflow.com/questions/41107/how-to-generate-a-random-alpha-numeric-string). 

The logic is simple, grab a random value in the array and add it to the string value until the logical break point (quantity of characters int he password) is met. 

```
import java.util.Random;

public class Jenny {

    private static String dCase = "";
    private static String uCase = "";
    private static String num = "";
    private static String sym = "";
    private static int uLength = 24;
    private static String kee = "";

    private static Random r = new Random();

    public static String Generate(){
        int l = getUCase().length();
        int u = getDCase().length();
        int n = getNum().length();
        int s = getSym().length();

        while (getKee().length () != getULength()){
            int rJen = r.nextInt(4);
            switch (rJen){
                case 0:
                    if(getDCase() == ""){
                        break;
                    }else {
                        int lGrab = r.nextInt(u);
                        setKee(getKee() + getDCase().charAt(lGrab));
                    }break;
                case 1:
                    if(getUCase() == ""){
                        break;
                    }else {
                        int uGrab = r.nextInt(l);
                        setKee(getKee() + getUCase().charAt(uGrab));
                    }break;
                case 2:
                    if(getSym() == ""){
                        break;
                    }else {
                        int sGrab = r.nextInt(s);
                        setKee(getKee() + getSym().charAt(sGrab));
                    }break;
                case 3:
                    if(getNum() == ""){
                        break;
                    }else {
                        int nGrab = r.nextInt(n);
                        setKee(getKee() + getNum().charAt(nGrab));
                    }break;
            }
        }
        return getKee();
    }

    public static void main (String[] args) {
        String key = Generate();
        System.out.println(key);
    }
```

### Selectors
What was more interesting was adding in the selectors requirements, for example if the site requires only alphanumerics you would make that selection in the check boxes

```
 public void setList() {
        list.add("@"); list.add("#"); list.add("$"); list.add("%"); list.add("^"); list.add("~");
        list.add("&"); list.add("*"); list.add(";"); list.add(":"); list.add("\""); list.add("+");
        list.add("-"); list.add("_"); list.add("="); list.add("/"); list.add("£"); list.add(".");
    }

    public void onCheckboxClicked(View view) {

        // Is the checkbox checked?
        boolean checked = ((CheckBox) view).isChecked();
        // Check which checkbox was clicked and do something.
        switch (view.getId()) {
            case R.id.lower_checkbox:
                if (checked) {
                    jenny.setDCase("abcdefghijklmnopqrstuvwxyz");
                } else {
                    jenny.setDCase("");
                }
                break;
            case R.id.upper_checkbox:
                if (checked) {
                    jenny.setUCase("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
                } else {
                    jenny.setUCase("");
                }
                break;
            case R.id.numerical_checkbox:
                if (checked) {
                    jenny.setNum("0123456789");
                } else {
                    jenny.setNum("");
                    break;
                }
        }
    }
```

### Database storage
I found this element of the interface quite difficult and is still nto complete following some space issues on the old laptop and account changes from russellclarke82 and developing82.

Ther database is intended to store passwords securely as a password manager as part of the paid version which was going to come into play, however, a lot more code is required and it will take some time.

Theres obviously an account login section required first off and then to secure and hash the data whilst it is stored in a secure storage file locally or backed up to the account of the user. The code is old code and there has been some progress with the Database feature of the app, not worth mentioning.
```
package com.local.russellclarke.passgen;

public class db {

    void onCommit(){

    }

    void onCommit(){

    }

    void onRollback(){

    }
}
```

### What next?
To complete the paid version and have it hosted for anyone who wants it?
<head>
    <meta content="text/html; charset=utf-8" http-equiv="Content-Type">
    <meta charset="UTF-8">
    <meta name="description" content="Projects and Portfolio">
    <meta name="keywords" content="HTML, CSS, JavaScript, PHP, MySQLi, Python, Java, C, C++, C#, Time, Shapes">
    <meta name="author" content="Russell Clarke">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<footer class="w3-container w3-teal w3-center w3-margin-top">
  <p>Find me on social media.</p>
  <a href="https://www.facebook.com/profile.php?id=100075972987666"><i class="fa fa-facebook-official w3-hover-opacity"></i></a>
  <a href="https://www.instagram.com/russellclarke821"><i class="fa fa-instagram w3-hover-opacity"></i></a>
  <a href="https://www.pinterest.co.uk/russellclarke821/"><i class="fa fa-pinterest-p w3-hover-opacity"></i></a>
  <a href="https://twitter.com/Developing821"><i class="fa fa-twitter w3-hover-opacity"></i></a>
  <a href="https://www.linkedin.com/in/russell-clarke-09a1a5238"></a><i class="fa fa-linkedin w3-hover-opacity"></i>
  <p>Powered by <a href="https://www.w3schools.com/w3css/default.asp" target="_blank">w3.css</a></p>
</footer>
