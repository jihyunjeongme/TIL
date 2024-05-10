let boy = {
    name: "Mike",
    showName: () => {
        console.log(this.name);

    }
};

let man = boy;
// man.showName();
boy = null;

man.showName();
