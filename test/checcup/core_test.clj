(ns checcup.core-test
  (:require [checcup.core :refer :all]
            [expectations.clojure.test
             :refer
             [defexpect expect expecting]]
            [clojure.test.check.generators :as gen]))

(defexpect base-gens-test
  (expecting "numbers"
             (expect gen/nat (gen :nat))
             (expect gen/small-integer (gen :small-integer))
             (expect gen/large-integer (gen :large-integer))
             (expect gen/double (gen :double))
             (expect gen/size-bounded-bigint (gen :size-bounded-bigint)))
  (expecting "boolean"
             (expect gen/boolean (gen :boolean)))
  (expecting "byte[s]"
             (expect gen/byte (gen :byte))
             (expect gen/bytes (gen :bytes)))
  (expecting "char and chars"
             (expect gen/char (gen :char))
             (expect gen/char-ascii (gen :char-ascii))
             (expect gen/char-alphanumeric (gen :char-alphanumeric))
             (expect gen/char-alpha (gen :char-alpha)))
  (expecting "strings"
             (expect gen/string (gen :string))
             (expect gen/string-ascii (gen :string-ascii))
             (expect gen/string-alphanumeric (gen :string-alphanumeric)))
  (expecting "keywords"
             (expect gen/keyword (gen :keyword))
             (expect gen/keyword-ns (gen :keyword-ns)))
  (expecting "symbols"
             (expect gen/symbol (gen :symbol))
             (expect gen/symbol-ns (gen :symbol-ns)))
  (expecting "ratios"
             (expect gen/ratio (gen :ratio))
             (expect gen/big-ratio (gen :big-ratio)))
  (expecting "uuid"
             (expect gen/uuid (gen :uuid)))
  (expecting "simple types"
             (expect gen/simple-type (gen :simple-type))
             (expect gen/simple-type-printable (gen :simple-type-printable))
             (expect gen/simple-type-equatable (gen :simple-type-equatable))
             (expect gen/simple-type-printable-equatable
                     (gen :simple-type-printable-equatable)))
  (expecting "any"
             (expect gen/any (gen :any))
             (expect gen/any-printable (gen :any-printable))
             (expect gen/any-equatable (gen :any-equatable))
             (expect gen/any-printable-equatable
                     (gen :any-printable-equatable))))
