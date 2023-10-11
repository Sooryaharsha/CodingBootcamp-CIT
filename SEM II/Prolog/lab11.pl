% Facts for Location predicate
location(chennai, tamilnadu).
location(coimbatore, tamilnadu).
location(bangalore, karanataka).
location(hydrabad, telungana).
location(delhi, hryana).
location(mumbai, maharastra).

% Facts for Stays predicate
stays(Akilesh, chennai).
stays(Suresh, bangalore).
stays(Vinoth, delhi).
stays(Rajaram, coimabtore).
stays(Kavin, hydrabad).
stays(Varadhan, mumbai).

% Rules to display list of person, state, and city
list_person_state_city :-
    findall(Person-State-City, (stays(Person, City), location(City, State)), List),
    write_list(List).

write_list([]).
write_list([Person-State-City|Rest]) :-
    write('Person: '), write(Person),
    write(', State: '), write(State),
    write(', City: '), write(City), nl,
    write_list(Rest).

% Rule to find the state in which a given person is staying
find_state(Person, State) :-
    stays(Person, City),
    location(City, State).

% Example usage:
% To display the list of person, state, and city:
% ?- list_person_state_city.

% To find the state in which a person is staying:
% ?- find_state(person2, State).
% Output: State = state2