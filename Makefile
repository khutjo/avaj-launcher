# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: kmaputla <marvin@42.fr>                    +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2019/06/25 14:15:45 by kmaputla          #+#    #+#              #
#    Updated: 2019/06/25 14:15:59 by kmaputla         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

all:compilie

compilie:
	@echo "compiling java files"
	@javac 		Tower.java\
				Baloon.java\
				Flyable.java\
				Aircraft.java\
				JetPlane.java\
				SortData.java\
				Main.java\
				Helicopter.java\
				FileWriters.java\
				Coordinates.java\
				WeatherTower.java\
				AircraftFacroty.java\
				WeatherProvider.java\

run:
	java main scenario.txt

clean:
	@echo "removing simulation.txt"
	@rm simulation.txt

fclean:clean
	@echo "removing class files"
	@rm	Tower.class\
		Baloon.class\
		Flyable.class\
		Aircraft.class\
		JetPlane.class\
		SortData.class\
		Main.class\
		Helicopter.class\
		FileWriters.class\
		Coordinates.class\
		WeatherTower.class\
		AircraftFacroty.class\
		WeatherProvider.class\
