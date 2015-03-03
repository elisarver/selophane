Selophane
=========

Selophane provides extensions to [Selenium-WebDriver](http://seleniumhq.org/)'s [WebElement](http://selenium.googlecode.com/svn/trunk/docs/api/java/org/openqa/selenium/WebElement.html) interface.

Element is the main concept in Selophane. It's a small core of functionality around which a family tree of classes is built, partially modeling the common structures of an average html page. 

It's meant to save conceptual time, since a Select has a better semantic  is better than knowing it implements interface WebElement, which tells you nothing.

Also, as a teachable example of how that works, check out how that Select class works. Its extensions and implementations should make the flow clear. In that class we wrap the WebElement again with a built-in helper from the core Selenium library. We add a few methods of our own to the Interface and implementation as well. 
You can find a explanation in detail about 
[the idea](http://elisarver.com/2012/12/09/wrapping-webelement-1) and [concrete implementation ](http://elisarver.com/2012/12/10/wrapping-webelement-2) in the blog. 

This project does not not rely upon a dependency injection framework like Spring or Guice. We don't do anything to prevent you from using injection, but we'd prefer to work at the same level the core of Selenium and not assume such things.

This project is in very early stages, with small modifications when issues arise. I do recognize that it seems a bit demo-like. There is a solution to that: contribute! If you have a really good idea for a set of behaviors, try to implement it, and send a pull request so we can integrate it.

I'm presently the sole member of my team on this project. I'm aware I'm not the greatest programmer on earth, so send in a pull request and I'll learn from it. I have not problem with criticism. Rejection of a new feature will probably not be a problem so long as it is a general case and doesn't add a lot of weight.

I don't mind feature requests, bugs, etc. Please use the facilities proved in the ribbon above to register an issue and the system will notify me of the request. If I don't get back to you, you can reach me at the locations below.

Thank you,

Eli Sarver

```
       eli@elisarver.com  (bounce ideas, whatever else)
github.com/elisarver
           elisarver.com  (blog, some other pages)
```

Contributors:
- Joe van der Wee (github.com/jvanderwee) - table objects!
- Niels (github.com/opensource21) - generic objects!
