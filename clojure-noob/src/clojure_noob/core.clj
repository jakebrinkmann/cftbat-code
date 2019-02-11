(ns clojure-noob.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "I'm a little teapot!"))

(println "Cleanliness is next to godliness")

(defn train 
  []
  (println "Choo choo!")
)
(+ 1 (* 2 3) 4)


(defn error-message
  [severity]
  (str "OH GOD! IT'S A DISASTER! WE'RE"
       (if (= severity :mild) 
         "MILDLY INCONVENIENCED!"
         "DOOOOOMED!"))
)

{:name {:first "John"}}

(hash-map :name (hash-map :first "John"))

(get {:a 0 :b 1} :b)

(get {:a 0 :b {:c "ho hum"}} :b)
; => {:c "ho hum"}

(get {:a 0 :b 1} :c "unicorns?")

(get-in {:a 0 :b {:c "ho hum"}} [:b :c])

({:a 0 :b {:c "ho hum"}} :b)

(:d {:a 0 :b 1} "No gnome knows homes like Noah knows")

[3 2 1]



(vector ["creepy" "full" "moon"])

(conj [1 2 3] 4)

(nth '(:a :b :c) 2)

#{"kurt vonnegut" 20 :icicle}

(hash-set 1 1 2 2)

(set [1 2 3 4])

(contains? #{:a :b} :a)

(:a #{:a :b})

(first [1 2 3 4])

(or + - )

((or + -) 1 2 3)

(map inc [0 1 2 3 4.1])


(defn too-enthusiastic
  "Return a cheer that might be a bit too enthusiastic"
  [name]
  (str "OH. MY. GOD! " name " YOU ARE MOST DEFINITELY LIKE THE BEST "
       "MAN SLASH WOMAN EVER I LOVE OU AND WE SHOULD RUN AWAY SOMEWHERE"))

(too-enthusiastic "Zelda")

(doc too-enthusiastic)


(defn multi-arity
  ([first-arg second-arg third-arg]
   (str "three! " first-arg second-arg third-arg))
  ([first-arg second-arg]
   (str "two! " first-arg second-arg)))

(multi-arity 1 2 3)

(defn x-chop
  "Describe the kind of chip you're inflicint on someone"
  ([name chop-type]
   (str "I " chop-type " chop " name "! Take that!"))
  ([name]
   (x-chop name "karate")))

(x-chop "Kanye West")

(defn my-first
  [[first-thing]]
  first-thing)

(my-first ["hi" "there" "bike"])

(defn chooser
  [[first-choice second-choice & unimportant-choices]]
  (println (str "Your first choice is: " first-choice))
  (println (str "Your second choice is: " second-choice))
  (println (str "We're ignoring the rest of your choices. "
                "Here they are in case you need to cry over them: "
                (clojure.string/join ", " unimportant-choices))))

(chooser ["marmalade", "handsome jack", "pigpen", "aquaman"])

(defn announce-treasure
  [{lat :lat lng :lng}]
  (println (str "Treasure lat: " lat))
  (println (str "Treasure lng: " lng)))

(announce-treasure {:lat 28.2 :lng 81.3})

(map (fn [name] (str "Hi, " name)) [ "Darth Vadar", "Mr. Magoo"])

((fn [x] (* x 3)) 8)

(def my-special-multiplier (fn [x] (* x 3)))

(my-special-multiplier 8 )

(#(str % " and " %2) "cornbread" "butter beans")


(def asym-hobbit-body-parts [{:name "head" :size 3}
                             {:name "left-eye" :size 1}])

(defn matching-part 
  "Take in a body (left or singleton) part, and return the righty-version"
  [part]
  {:name (clojure.string/replace (:name part) #"^left-" "right-") 
   :size (:size part)})

(defn symmetrize-body-parts
  "Convert seq of maps with :name and :size"
  [asym-body-parts]
  (loop [remaining-asym-parts asym-body-parts 
         final-body-parts []]
    (if (empty? remaining-asym-parts) 
      final-body-parts
      (let [[part & remaining] remaining-asym-parts]
        (recur remaining
               (into final-body-parts
                     (set [part (matching-part part)])))))))

(symmetrize-body-parts asym-hobbit-body-parts)

(into [] (set [:a :b :a]))

(rest [1 2 3 4])

(doc rest)

(loop [iteration 0]
  (println (str "I:" iteration))
  (if (> iteration 3)
    (println "Goodbye!")
    (recur (inc iteration))))


(loop [i 0]
  (if (< i 1) 
    (recur (inc i))
    (str "Done! " i))
  )


(re-find #"^left-" "left-eye")


(defn better-symer 
  [asym-parts]
  (reduce (fn [result part]
            (into result (set [part (matching-part part)]))) 
          [] 
          asym-parts))

(better-symer asym-hobbit-body-parts)

(defn hit
  [asym-parts]
  (let [sym-parts (better-symer asym-parts)
        body-size (reduce + (map :size sym-parts))
        target (rand body-size)]
    (loop [[part & remaining] sym-parts
           a-size (:size part)]
      (if (> a-size target)
        part
        (recur remaining (+ a-size (:size (first remaining))))))))

(hit asym-hobbit-body-parts)


(defn hundo [num] (+ num 100))

(hundo 1)

(defn dec-maker
  "Custom decrement function, default by 1"
  ([offset] #(- % offset))
  ([] (dec-maker 1))
)

((dec-maker 9) 10)

(defn mapset 
  [f coll]
  (set (map f coll) ))

(mapset inc [1 1 2 2])

