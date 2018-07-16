# Ejercicio Etermax - 3 Iteraciones
  
  Your mission is to create a game with simple combat rules, as for a roleplaying game (RPG). It is implemented as a sequence of iterations. The domain doesn't include a map or any other character skills apart from their ability to damage and heal one another. Complete each iteration before reading the next one.
  
  Iteration One
  1. All Characters, when created, have: - Health, starting at 1000 - Level, starting at 1 - May be Alive or Dead, starting Alive (Alive may be a true/false) 
  2. Characters can Deal Damage to Characters. - Damage is subtracted from Health - When damage received exceeds current Health, Health becomes 0 and the character dies 
  3. A Character can Heal a Character. - Dead characters cannot be healed - Healing cannot raise health above 1000
  
  Iteration Two
  1. The Character can deal damage to his enemies, but not to himself. 
  2. The Character can heal himself, but not his enemies. 
  3. The level now has an effect on the damage applied: - If the target is 5 or more levels above the attacker, Damage is reduced by 50% - If the target is 5 or more levels below the attacker, Damage is increased by 50%
  
  Iteration Three
  1. The Character has an attack range. 
  2. Melee fighters have a range of 2 meters. 
  3. Ranged fighters have a range of 20 meters. 
  4. When trying to deal damage, the Character must be in range.
  
  Retrospective
  - Are you keeping up with the requirements? Has any iteration been a big challenge? - Do you feel good about your design? Is it scalable and easily adapted to new requirements that will be introduced in the last iterations? - Is everything tested and are you confident in your tests?