(ns checcup.core
  (:require [clojure.test.check.generators :as gen]))

(def base-gens
  #{:nat
    :small-integer
    :large-integer
    :double
    :size-bounded-bigint
    :boolean
    :byte
    :bytes
    :char
    :char-ascii
    :char-alphanumeric
    :char-alpha
    :string
    :string-ascii
    :string-alphanumeric
    :keyword
    :keyword-ns
    :symbol
    :symbol-ns
    :ratio
    :big-ratio
    :uuid
    :simple-type
    :simple-type-printable
    :simple-type-equatable
    :simple-type-printable-equatable
    :any
    :any-printable
    :any-equatable
    :any-printable-equatable})

(defn gen [checcup]
  (cond
    (and (keyword? checcup) (not (base-gens checcup)))
    (throw (ex-info "I don't know how to convert that to a generator." {:value checcup}))

    (keyword? checcup) @(ns-resolve 'clojure.test.check.generators (symbol (name checcup)))

    :else
    (throw (ex-info "I don't know how to convert that to a generator." {:value checcup}))))
