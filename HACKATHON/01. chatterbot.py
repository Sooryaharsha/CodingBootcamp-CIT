from chatterbot.trainers
import ListTrainer
from chatterbot
import ChatBot
chatbot = ChatBot("New_Bot")
conversation = [
    "Hello",
    "Hi, there!",
    "How are you doing?",
    "I'm doing great.",
    "That is good to hear",
    "how can i help you?",
    "Thank you.",
    "You're welcome."
]

trainer = ListTrainer(chatbot)

trainer.train(conversation)

print("enter 'quit' to stop")
while True:
  text_input = input("You: ")
if text_input == 'quit':
  break
print("Bot:", chatbot.get_response(text_input)) 