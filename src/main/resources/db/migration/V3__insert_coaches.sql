-- Inserção de técnicos
-- Técnico do Atlético-MG
INSERT INTO coaches (name, salary, country, born_at, debut_at, height, weight, photo_path, tactical_style, training_methodology, current_club_id)
VALUES
('Cuca', 700000, 'Brasil', '1963-06-07', '1998-01-01', 1.83, 75, '', 'Ofensivo', 'Treinos intensivos', (SELECT id FROM clubs WHERE name = 'Atlético-MG')),
('Rogério Ceni', 700000, 'Brasil', '1973-01-22', '2017-01-01', 1.88, 82, '', 'Posse de bola', 'Treinos táticos', (SELECT id FROM clubs WHERE name = 'Bahia')),
('Renato Paiva', 400000, 'Portugal', '1970-03-22', '2019-01-01', 1.80, 78, '', 'Defensivo', 'Treinos estratégicos', (SELECT id FROM clubs WHERE name = 'Botafogo')),
('Léo Condé', 200000, 'Brasil', '1978-04-21', '2010-01-01', 1.75, 70, '', 'Transições rápidas', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'Ceará')),
('Ramón Díaz', 1600000, 'Argentina', '1959-08-29', '1995-01-01', 1.72, 74, '', 'Ofensivo', 'Treinos táticos', (SELECT id FROM clubs WHERE name = 'Corinthians')),
('Leonardo Jardim', 1000000, 'Venezuela', '1974-08-01', '2001-01-01', 1.78, 72, '', 'Posse de bola', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'Cruzeiro')),
('Filipe Luís', 700000, 'Brasil', '1985-08-09', '2024-09-30', 1.82, 73, '', 'Ofensivo', 'Treinos intensivos', (SELECT id FROM clubs WHERE name = 'Flamengo')),
('Mano Menezes', 600000, 'Brasil', '1962-06-11', '2004-01-01', 1.82, 76, '', 'Defensivo', 'Treinos estratégicos', (SELECT id FROM clubs WHERE name = 'Fluminense')),
('Juan Pablo Vojvoda', 790000, 'Argentina', '1975-01-13', '2015-01-01', 1.85, 77, '', 'Pressão alta', 'Treinos físicos', (SELECT id FROM clubs WHERE name = 'Fortaleza')),
('Gustavo Quinteros', 700000, 'Argentina', '1965-02-15', '2003-01-01', 1.81, 75, '', 'Ofensivo', 'Treinos táticos', (SELECT id FROM clubs WHERE name = 'Grêmio')),
('Roger Machado', 850000, 'Brasil', '1975-03-04', '2014-01-01', 1.76, 74, '', 'Posse de bola', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'Internacional')),
('Fábio Matias', 100000, 'Brasil', '1979-09-25', '2018-01-01', 1.77, 73, '', 'Transições rápidas', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'Juventude')),
('Eduardo Barroca', 150000, 'Brasil', '1982-04-22', '2019-01-01', 1.76, 72, '', 'Defensivo', 'Treinos estratégicos', (SELECT id FROM clubs WHERE name = 'Mirassol')),
('Abel Ferreira', 2700000, 'Portugal', '1978-12-22', '2013-01-01', 1.78, 76, '', 'Ofensivo', 'Treinos táticos', (SELECT id FROM clubs WHERE name = 'Palmeiras')),
('Fernando Seabra', 300000, 'Brasil', '1977-06-19', '2013-01-01', 1.81, 75, '', 'Pressão alta', 'Treinos físicos', (SELECT id FROM clubs WHERE name = 'RB Bragantino')),
('Pedro Caixinha', 800000, 'Portugal', '1970-11-15', '2010-01-01', 1.85, 75, '', 'Pressão alta', 'Treinos físicos', (SELECT id FROM clubs WHERE name = 'Santos')),
('Luis Zubeldía', 1100000, 'Argentina', '1981-01-13', '2008-01-01', 1.78, 74, '', 'Posse de bola', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'São Paulo')),
('Pepa', 300000, 'Portugal', '1980-12-14', '2013-01-01', 1.86, 74, '', 'Ofensivo', 'Treinos táticos', (SELECT id FROM clubs WHERE name = 'Sport')),
('Fábio Carille', 500000, 'Brasil', '1973-09-26', '2017-01-01', 1.86, 77, '', 'Defensivo', 'Treinos estratégicos', (SELECT id FROM clubs WHERE name = 'Vasco')),
('Thiago Carpini', 180000, 'Brasil', '1984-07-16', '2019-01-01', 1.85, 70, '', 'Posse de bola', 'Treinos técnicos', (SELECT id FROM clubs WHERE name = 'Vitória'))