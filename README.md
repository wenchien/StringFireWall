![Java Versions][java-version]
![JavaFx][javafx-version]
![Maven][maven-version]

# About the project
A small library that demonstrates the following:
1. Firewall best practices are generally applied based on the rule of "allow exceptions, then deny all", at least for enterprises internal network. This small Java class demonstrates this as a proof of concept
2. Encourages cleaner code.

# Usage

Using StringFirewall is easy! 
1. Create a new StringFirewall instance by calling the static method
```Java
var stringFirewall = StringFirewall.getStringFirewall();
```

2. Upon successful creation of the StringFirewall object, you may call two methods: `allow` and `evaluate`:
```Java
stringFirewall.allow("some regex here")
```
```Java
stringFirewall.evaluate("Some test message");
```

# Notes
1. Do note that `evaluate` is generally called after one or several `allow` calls. Method chaining is available: 
```Java
stringFirewall.allow("some regex here").allow("second regex").allow(StringFirewallOption.ALLOW_HTML_CHARACTERS);
var isOk = stringFirewall.evaluate("Some test message");
```

2. The `allow` method, though only accepts regex, accepts three different types of parameters: `StringFirewallOption`, `String`, and `List<String>`:
```Java
allow(List<String> customStringRules)
allow(StringFirewallOption option)
allow(String regex)
```

3. The `evaluate` method will strictly match the regex patterns provided; meaning that if there are patterns / strings / characters that don't match with what was given via `allow`, it will return `false` instead of `true`:
```Java
boolean isOk = StringFirewall.getStringFirewall().allow("[A-Z]").evaluate("ABC123");
// isOk will evaluate to false, you will need to allow("[0-9]") for the above statement to evaluate to true
```


<!-- LICENSE -->
## License

MIT License

Copyright 2022 Wen Chien Chang

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[javafx-version]: https://img.shields.io/badge/JavaFX-19--ea%2B8-orange
[java-version]: https://img.shields.io/badge/Java-8%2B-red
[maven-version]: https://img.shields.io/badge/maven-v1.0-blue
