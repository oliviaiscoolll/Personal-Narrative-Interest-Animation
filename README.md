# Unit 5 - Personal Narrative / Interest Animation

## Introduction

Images are often used to portray our personal experiences and interests. We also use image filters and effects to change or enhance the mood of an image. When combined into collages and presentations, these images tell a story about who we are and what is important to us. Your goal is to create an animation using The Theater and Scene API that consists of images of your personal experiences and/or interests. In this animation, you will incorporate data related to these experiences and/or interests that can be organized in a 2D array, and use image filters and effects to change or enhance the mood of your images.
## Requirements

Use your knowledge of object-oriented programming, two-dimensional (2D) arrays, and algorithms to create your personal narrative collage or animation:
- **Write Scene subclasses** – Create two Scene subclasses: either two core parts of your personal life, or two components of a personal interest. Each class must contain a constructor and private instance variable with data related to the scene
- **Create at least two 2D arrays** – Create at least two 2D arrays to store the data that will make up your visualization.
Implement algorithms – Implement one or more algorithms that use loops and logic that operate on the data in your 2D arrays.
- **Create a visualization** – Create an animation that conveys the story of the data by illustrating the patterns or relationships in the data.
- **Image Filters** – Utilize the image filters created in this unit (and possible new filters) that show a personal flare to the images used in your animation.
- **Document your code** – Use comments to explain the purpose of the methods and code segments and note any preconditions and postconditions.

## UML Diagram

Put an image of your UML Diagram here. Upload the image of your UML Diagram to your repository, then use the Markdown syntax to insert your image here. Make sure your image file name is one work, otherwise it might not properly get displayed on this README.

![UML Diagram for my project](![alt text](<Copy of Unit 5 - UML Diagram.png>))

## Video

Record a short video of your story to display here on your README. You can do this by:

- Screen record your project running on Code.org.
- Upload that recording to YouTube.
- Take a thumbnail for your image.
- Upload the thumbnail image to your repo.
- Use the following markdown

[![Thumbnail for my projet](![alt text](<Screenshot 2026-02-21 at 9.29.08 AM.png>))](https://youtu.be/_J1dfb3WUco)
**(Audio does not show up on screen recording but audio works)**

## Story Description

My animation tells the story of my personal experiences through travel and tennis. In the travel class scene, images of Hawaii, Mexico, and Washington DC are shown with filters. Alongside each image, the animation displays how many days I spent at each location and my personal rating, giving context to my trips. This information comes from a 2D array called travelStats, where each row represents a different location, and the two columns store the number of days and the rating. This allows the animation to connect the data directly to the visual images. In the tennis class scene, each match is represented with an image of the court from the school I have played and a filter, along with the match score and total points played. The images are stored in a 2D array of ImageFilter objects, where each row represents a match, and each column could hold different filtered versions of the same image. The scores are stored in an array corresponding to the rows of the image array, linking each image to the performance data. By using these 2D arrays, my animation illustrates my personal experiences, showing both the visuals and the data together.

## Image Filter Analysis

In my animation, I used both the Sepia and Negative filters to enhance the mood of the images. The sepia filter gives images a warm, brown toned effect by recalculating each pixel’s RGB values using a formula that increases the red and green pixels while slightly reducing the blue, creating a nostalgic, antique look. The negative filter, on the other hand, inverts the colors of each pixel by subtracting the red, green, and blue values from 255, turning dark areas light and light areas dark. This creates a high contrast, dramatic effect. 