% Facts for parent predicate
parent(john, mary).
parent(john, peter).
parent(steve, amy).
parent(steve, mark).
parent(anna, lisa).
parent(anna, david).

% Facts for gender predicate
female(mary).
female(lisa).
female(anna).
male(john).
male(steve).
male(peter).
male(mark).
male(david).

% Rule 1: M is the mother of P if she is a parent of P and is female
mother(M, P) :-
  parent(M, P),
  female(M).

% Rule 2: F is the father of P if he is a parent of P and is male
father(F, P) :-
  parent(F, P),
  male(F).

% Rule 3: X is a sibling of Y if they both have the same parent
sibling(X, Y) :-
  parent(P, X),
  parent(P, Y),
  X \= Y.

% Rule 4: Grandparents
grandparent(GP, GC) :-
  parent(GP, X),
  parent(X, GC).

% Rule 5: Uncle-Aunt
uncle(U, N) :-
  sibling(U, X),
  parent(X, N),
  male(U).

aunt(A, N) :-
  sibling(A, X),
  parent(X, N),
  female(A).

% Rule 6: Sister and Brother
sister(S, N) :-
  sibling(S, N),
  female(S).

brother(B, N) :-
  sibling(B,N),
  male(B).