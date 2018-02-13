
## Chapter 1: Hello World

"Clojure" can mean two things, the language (syntax/semantics) or the compiler (`clojure.jar`). This is important because the language is "hosted", meaning source code is executed by the JVM: 
```bash
# Normal Java Packaging
Java source code --> [Java Compiler] --> Java bytecode --> JAR files <-- JVM

# Clojure Packaging
Clojure source --> [Clojure.jar <-- JVM] --> Java bytecode <-- JVM
```

### Projects

Installing `lein` will also download `clojure.jar`:
```bash
java -version
wget https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
mv lein ~/bin
lein
lein version
ls ~/.lein/self-installs
```

Leiningen (`lein') can create a project skeleton:
```bash
lein new app clojure-noob
```
This makes a new folder `./clojure-noob` which contains everything a new project could need (`LICENSE`, `README.md` ..). 
Importantly, `project.clj` is used by `lein` for dependencies and an entrypoint at runtime. 


### Running
A boilerplate `clojure-noob/src/clojure_noob/core.clj` is created, which is run by:
```bash
cd clojure-noob/
lein run
# Retrieving org/clojure/clojure/1.8.0/clojure-1.8.0.pom from central
# ...
# Hello, World!
```

### Packaging
Or, to create a stand-alone (+Java) file:
```bash
lein uberjar
# Compiling clojure-noob.core
java -jar target/uberjar/clojure-noob-0.1.0-SNAPSHOT-standalone.jar
# Hello, World!
```

### Interactive
The REPL interacts with a running Clojure process, allowing modifications:
```bash
lein repl
# ...
# clojure-noob.core=> 
```
This is useful for quickly seeing the results of code, but can be powerful to connect to and modify a live running application. 

