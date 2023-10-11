location(chennai,tamilnadu).
loaction(kochi,kerala).
loaction(bengaluru,karnataka).
loaction(coimbatore,tamilnadu).
location(tiruvandram,kerala).

stays(soorya,coimbatore).
stays(jaime,tiruvandram).
stays(daemon,kochi).
stays(jonsnow,bengaluru)
stays(oliver,chennai).

list_details :-
    findall(Person-State-City,(stays(Person,City),location(City,State)),List),
    write_list(List).

write_list([]).
write_list([Person-State-City|Rest]):-
    write('Person: '), write(Person),
    write(', State: '), write(State),
    write(', City: '), write(City), nl,
    write_list(Rest).


find_state(Person, State) :-
    stays(Person, City),
    location(City, State).
