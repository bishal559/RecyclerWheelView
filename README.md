# RecyclerWheelView

An efficient Android WheelView  based on RecyclerView, which is easy to use, and it can customized by yourself.

## Getting Started

First of all, this lib is based on androidx, *if your library do not migrate to androidx, there might be some problems* if you used this.







## Result

there are two examples' results about recyclerwheelview in this project, if you used recyclerwheelview, you can  make this effect easily.

###  wheel view
![Screenshot 2024-02-11 at 10 40 38](https://github.com/bishal559/RecyclerWheelView/assets/65449966/0d7e891f-5445-4da8-ac7e-a3756b21ed89)



The attributes of StringWheelView and its explain as follows:

| attribute name                      | explain                                                         | example                                                         |
| --------------------------- | ------------------------------------------------------------ | ------------------------------------------------------------ |
| wheelSelectedItemTextColor  | the color of selected String                                         | app:wheelSelectedItemTextColor="@color/colorAccent"          |
| wheelSelectedTextSize       | the size of selected String                                         | app:wheelSelectedTextSize="18sp"                             |
| wheelSelectedItemBackground | the background of selected String item（can use custom drawable）                     | app:wheelSelectedItemBackground="@drawable/string_selected_wheel_bg" |
| wheelNormalTextSize         | the size of unselected String                                       | app:wheelNormalTextSize="15sp"                               |
| wheelNormalTextColor        | the color of unselected String                                       | app:wheelNormalTextColor="@color/colorPrimaryDark"           |
| wheelNormalItemBackground   | the background of unselected String item（can use costom drawable）                   | app:wheelNormalItemBackground="@drawable/string_nor_wheel_bg" |
| wheelItemHeight             | the height of String item, attention, the height of selected String item and unselected String item is same | app:wheelItemHeight="100dp"               |

### Background wheel view

![Screenshot 2024-02-11 at 11 12 21](https://github.com/bishal559/RecyclerWheelView/assets/65449966/f741155a-92ac-4ca7-b2bc-200375a9fe0b)


You can customize RecyclerWheelView just like recycler view， you can see how it realize in this demo project.



 
