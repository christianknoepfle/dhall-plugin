let Person =
      { Type = { name : Text, friends : List Text }
      , default = { friends = [] : List Text }
      }

let example = Person::{ name="foo" }

let b=3

in example